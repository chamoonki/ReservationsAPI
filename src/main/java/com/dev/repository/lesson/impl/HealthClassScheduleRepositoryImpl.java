package com.dev.repository.lesson.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.dev.dto.ScheduleClassDTO;
import com.dev.dto.SettingHealthClassDTO;
import com.dev.model.lesson.HealthClass;
import com.dev.model.lesson.HealthClassSchedule;
import com.dev.model.lesson.QHealthClass;
import com.dev.model.lesson.QHealthClassSchedule;
import com.dev.repository.lesson.custom.CustomHealthClassRepository;
import com.dev.repository.lesson.custom.CustomHealthClassScheduleRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * Schedule 관련 수업에 대한 DB에서 기본적인 쿼리를 제외한
 * 조건을 걸기 위한 Custom Implement
 * 
 * <pre>
 * com.dev.repository.lesson.impl
 * HealthClassScheduleRepositoryImpl.java
 * </pre>
 *
 * @author  : moonki.cha
 * @Date   : 2019. 12. 5.
 * @Version :
 */
public class HealthClassScheduleRepositoryImpl extends QuerydslRepositorySupport implements CustomHealthClassScheduleRepository {
	// JPAQueryFactory를 사용하기 위해 선언
	private final JPAQueryFactory queryFactory;
	
	// QuerydslRepositorySupport 클래스에는 기본생성자가 없음.
	// 생성 할 때 JPAQueryFactory도 주입 받는다.
    public HealthClassScheduleRepositoryImpl(JPAQueryFactory queryFactory) {
        super(HealthClassSchedule.class);
        // queryFactory 변수에 주입
        this.queryFactory = queryFactory;
    }
    
    /**
     * Calendar에 필요한 정보들만 가져오기 위한 쿼리 가공 함수
     * 
     * @author 	: moonki.cha
     * @date	: 2019. 12. 05
     */
    @Override
    public List<ScheduleClassDTO> getSchedule(Date startDate, Date endDate, String center_id) {
    	// HealthClass Table 생성
    	QHealthClass healthClass = QHealthClass.healthClass;
    	// HealthClassSchedule Table 생성
    	QHealthClassSchedule healthClassSchedule = QHealthClassSchedule.healthClassSchedule;
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	
    	JPQLQuery<ScheduleClassDTO> query = queryFactory
    		.select(Projections.bean(ScheduleClassDTO.class, 
    				healthClassSchedule.id.as("id"),
    				healthClass.name.as("title"),
    				healthClassSchedule.class_start_dd.as("startDateTime"),
    				healthClassSchedule.class_end_dd.as("endDateTime"),
    				healthClassSchedule.class_duration_time.as("duration"),
    				healthClassSchedule.class_week_interval.as("interval"),
    				healthClassSchedule.class_week
    				
    		))    		
    		.from(healthClassSchedule)
    		.join(healthClass).on(
				healthClass.id.eq(healthClassSchedule.health_class_id)
				.and(healthClass.center_id.eq(healthClassSchedule.center_id))
    		)
    		.where(
				healthClassSchedule.center_id.eq(center_id)
				.and(
					(healthClassSchedule.class_start_dd.between(startDate, endDate))
					.or(
						healthClassSchedule.class_start_dd.loe(startDate)
						.and(healthClassSchedule.class_end_dd.goe(startDate))
					)
				)		
    		); 
    	
    	return query.fetch();
    }
}
