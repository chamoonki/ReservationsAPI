package com.dev.repository.lesson.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.dev.dto.SettingHealthClassDTO;
import com.dev.model.lesson.HealthClass;
import com.dev.model.lesson.QHealthClass;
import com.dev.model.lesson.QHealthClassType;
import com.dev.model.user.QUser;
import com.dev.repository.lesson.custom.CustomHealthClassRepository;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * 수업에 대한 정보를 DB에서 기본 적인 쿼리를 제외한
 * 조건을 걸기 위한 Custom Class
 * 
 * <pre>
 * com.dev.repository.HealClass.impl
 * HealClassRepositoryImpl.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date	: 2019. 10. 24.
 * @Version :
 */
public class HealthClassRepositoryImpl extends QuerydslRepositorySupport implements CustomHealthClassRepository {
	// JPAQueryFactory를 사용하기 위해 선언
	private final JPAQueryFactory queryFactory;
	
	// QuerydslRepositorySupport 클래스에는 기본생성자가 없음.
	// 생성 할 때 JPAQueryFactory도 주입 받는다.
    public HealthClassRepositoryImpl(JPAQueryFactory queryFactory) {
        super(HealthClass.class);
        // queryFactory 변수에 주입
        this.queryFactory = queryFactory;
    }

    
    /**
     * 센터별 세팅 수업목록 데이터를 가져오는 쿼리 가공 함수
     * 
     * @author	: KIM MIN KI
     * @date 	: 2019. 10. 24.
     * 
     */
    @Override
    public List<SettingHealthClassDTO> getSettingHealthClassList(String center_id) {
    	// User Table 생성
    	QUser user = QUser.user;
    	// HealthClass Table 생성
    	QHealthClass healthClass = QHealthClass.healthClass;
    	// HealthClassType Table 생성
    	QHealthClassType healthClassType = QHealthClassType.healthClassType;
    	
    	// TODO: queryFactory를 이용 하여 Join 및 쿼리 작성 방법
		/*
		return queryFactory 
		  	.select(Projections.fields(User.class,
		  		userClassStatus.user_id.as("userId") 
		  	)) 
		  	.from(userClassStatus)
		  	.join(healthClass).on(userClassStatus.health_class_id.eq(healthClass.id))
		  	.fetch();
		*/
    			
    	// TODO: queryDsl을 이용하여 기본 쿼리 작성 방법
    	/*return from(user)
    			.where(user.center_id.eq(center_id))
    			.fetch();*/
    	
    	/*
    	 * 반환결과가 여러건일 경우(JPQL의 NEW명령어와 같이 DTO사용)
    	 * 
    	 * 1.Projections.bean() -> setter이용
    	 * 2.Projections.fields() -> 필드직접 접근.(reflection으로 접근하므로 private이여도 접근가능)
    	 * 3.Projections.constructor() -> 생성자로 접근, 생성자 매개변수와 순서가 동일해야함.
    	 * 4.ExpressionUtils dsl에서 제공하는 util 클래스이며 서브 쿼리를 넣기위한 기능을 제공한다.    	 * 
    	 */
    	JPQLQuery<SettingHealthClassDTO> query = queryFactory
			.select(Projections.bean(SettingHealthClassDTO.class, 
					healthClassType.id.as("health_class_type_id"),
					healthClassType.name.as("health_class_type_name"),
					healthClassType.remarks.as("health_class_type_remarks"),
					healthClass.name.as("health_class_name"),
					healthClass.center_id,
					healthClass.class_cnt,
					healthClass.class_cnt_payment,
					healthClass.class_day_max_cnt,
					healthClass.class_session_month,
					healthClass.class_session_payment,
					healthClass.class_session_type,
					healthClass.class_total_max_cnt,
					healthClass.class_user_max_cnt,
					healthClass.class_week_max_cnt,
					healthClass.id.as("health_class_id"),
					healthClass.instructor_id,
					healthClass.remarks.as("health_class_remarks"),
					ExpressionUtils.as(JPAExpressions.select(user.name).from(user).where(user.id.eq(healthClass.instructor_id)),"instructor_name"),
					ExpressionUtils.as(JPAExpressions.select(user.name).from(user).where(user.id.eq(healthClass.reg_id)),"reg_name"),
					healthClass.reg_dd,
					ExpressionUtils.as(JPAExpressions.select(user.name).from(user).where(user.id.eq(healthClass.mod_id)),"mod_name"),
					healthClass.mod_dd
			))
			.from(healthClass)
			.join(healthClassType).on(
					healthClassType.id.eq(healthClass.health_class_type_id)
					.and(healthClassType.center_id.eq(center_id))
			)
			.join(user).on(
					user.id.eq(healthClass.instructor_id)
			)
			.where(healthClass.center_id.eq(center_id));
    	
    	
    	
    	return query.fetch();
    }
}
