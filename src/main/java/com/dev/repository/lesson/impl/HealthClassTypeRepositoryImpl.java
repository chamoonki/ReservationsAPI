package com.dev.repository.lesson.impl;

import java.util.Date;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.dev.model.lesson.HealthClassType;
import com.dev.model.lesson.QHealthClassType;
import com.dev.repository.lesson.custom.CustomHealthClassTypeRepository;
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
public class HealthClassTypeRepositoryImpl extends QuerydslRepositorySupport implements CustomHealthClassTypeRepository {
	// JPAQueryFactory를 사용하기 위해 선언
	private final JPAQueryFactory queryFactory;
	
	// QuerydslRepositorySupport 클래스에는 기본생성자가 없음.
	// 생성 할 때 JPAQueryFactory도 주입 받는다.
    public HealthClassTypeRepositoryImpl(JPAQueryFactory queryFactory) {
        super(HealthClassType.class);
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
    public int updateById(HealthClassType health_class_type) {
    	// HealthClassType Table 생성
    	QHealthClassType healthClassType = QHealthClassType.healthClassType;
    	
    	/*
    	 * 반환결과가 여러건일 경우(JPQL의 NEW명령어와 같이 DTO사용)
    	 * 
    	 * 1.Projections.bean() -> setter이용
    	 * 2.Projections.fields() -> 필드직접 접근.(reflection으로 접근하므로 private이여도 접근가능)
    	 * 3.Projections.constructor() -> 생성자로 접근, 생성자 매개변수와 순서가 동일해야함.
    	 * 4.ExpressionUtils dsl에서 제공하는 util 클래스이며 서브 쿼리를 넣기위한 기능을 제공한다.    	 * 
    	 */
    	int result = (int) queryFactory.update(healthClassType)
					    	.where(healthClassType.id.eq(health_class_type.getId()))
					    	.set(healthClassType.name, health_class_type.getName())
					    	.set(healthClassType.remarks, health_class_type.getRemarks())
					    	.set(healthClassType.mod_id, health_class_type.getMod_id())
					    	.set(healthClassType.mod_dd, new Date())
					    	.execute();
    	
    	return result;
    }
}
