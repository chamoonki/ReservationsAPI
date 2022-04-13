package com.dev.repository.user.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.dev.dto.SettingInstructorDTO;
import com.dev.dto.SearchGridDTO;
import com.dev.model.lesson.QHealthClass;
import com.dev.model.user.QUser;
import com.dev.model.user.QUserHealthClassStatus;
import com.dev.model.user.User;
import com.dev.repository.user.custom.CustomUserRepository;
import com.dev.utils.convert.Utils;
import com.dev.utils.dsl.CommonFilter;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * 회원에 대한 정보를 DB에서 기본 적인 쿼리를 제외한
 * 조건을 걸기 위한 Custom Class
 * 
 * <pre>
 * com.dev.repository.user.impl
 * UserRepositoryImpl.java
 * </pre>
 *
 * @author  : moonki.cha
 * @Date	: 2019. 10. 15.
 * @Version :
 */
public class UserRepositoryImpl extends QuerydslRepositorySupport implements CustomUserRepository{
	
	@Autowired
	private CommonFilter commonFilter;
	
	// JPAQueryFactory를 사용하기 위해 선언
	private final JPAQueryFactory queryFactory;
	
	private Utils utils = new Utils();
	
	// QuerydslRepositorySupport 클래스에는 기본생성자가 없음.
	// 생성 할 때 JPAQueryFactory도 주입 받는다.
    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        // queryFactory 변수에 주입
        this.queryFactory = queryFactory;
    }
    
    @Override
    public List<SettingInstructorDTO> getChargedUser(String center_id, SearchGridDTO search) throws ParseException {
    	// user Table 생성
    	QUser user = QUser.user;
    	// userHealthClassStatus 생성
    	QUserHealthClassStatus userClassStatus = QUserHealthClassStatus.userHealthClassStatus;
    	// healthClass 생성
    	QHealthClass healthClass = QHealthClass.healthClass;
    	
    	// Order, Field에 대한 변수를 받아 준다.
    	String field = search.getSortField();
    	String order = search.getSortOrder();
    	int offset = search.getPageNumber();
    	int limit = search.getPageSize();
    	
    	
    	
    	
    	JPQLQuery<SettingInstructorDTO> query = queryFactory
			.select(Projections.bean(SettingInstructorDTO.class, 
					user.id.as("user_id"),
					user.name.as("user_name"),
					user.birthday,
					user.sex,
					user.phone,
					user.center_id.as("center_id"),
					userClassStatus.payment_class_cnt.as("payment_class_cnt"),
					userClassStatus.payment_class_status.as("payment_class_status"),
					userClassStatus.class_start_dd.as("class_start_dt"),
					userClassStatus.class_end_dd.as("class_end_dt"),
					healthClass.name.as("class_name")
			))
			.from(userClassStatus)
			.join(user).on(userClassStatus.user_id.eq(user.id))
			.join(healthClass).on(
					userClassStatus.health_class_id.eq(healthClass.id)
					.and(healthClass.center_id.eq(user.center_id))
			)
			.where(		
				user.center_id.eq(center_id)					// Center ID 와 같은지 확인
				.and(userClassStatus.payment_class_cnt.gt(0))	// 수업 결제 횟수 가 0보다 커야 한다.
				.and(userClassStatus.class_end_dd.after(utils.currentUTCDateTime()))	// 수업 종료 날짜보다 크거나 같아야 한다.
			)
			.orderBy(
					(field.indexOf("dd") >= 0 || field.indexOf("dt") >= 0) ?  	// field에 dd & dt 가 있는지 확인 
					selectExpiredOrder(userClassStatus, field, order) :			// 있다면 Date 타입이기 때문에 해당 타입에 맞게 설정
					(field.indexOf("cnt") >= 0) ? 								// field에 cnt 가 있는지 확인
					selectExpiredOrder(userClassStatus, healthClass, field, order) :	// 있다면 Integer 타입이기 때문에 해당 타입에 맞게 설정
					selectExpiredOrder(user, userClassStatus, healthClass, field, order)
					
							
			)
			.offset(offset * limit).limit(limit);
    	
    	return query.fetch();
    }
    
    
    /**
     * 만기 회원 목록 데이터를 가져오는 쿼리 가공 함수
     * 
     * @author	: moonki.cha
     * @throws ParseException 
     * @date 	: 2019. 10. 15
     * 
     */
    @Override
    public List<SettingInstructorDTO> getExpiredUser(String center_id, SearchGridDTO search) throws ParseException {
    	// user Table 생성
    	QUser user = QUser.user;
    	// userHealthClassStatus 생성
    	QUserHealthClassStatus userClassStatus = QUserHealthClassStatus.userHealthClassStatus;
    	// healthClass 생성
    	QHealthClass healthClass = QHealthClass.healthClass;
    	
    	// Order, Field에 대한 변수를 받아 준다.
    	String field = search.getSortField();
    	String order = search.getSortOrder();
    	int offset = search.getPageNumber();
    	int limit = search.getPageSize();
    	
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
    			.fetch();
    			
    			.where(qMember.age.gt(30))
                                                  .orderBy(qMember.age.desc())
                                                  .offset(0).limit(2)
                                                  .listResults(
                                                  
                                                  
                                                  uery.from(qOrder)
                                      .where(qOrder.member.username.eq("여성게1"))
                                      .join(qOrder.member,qMember)
                                      .leftJoin(qOrder.product,qProduct)
                                      .list(qOrder);
                                      .where(qMember.username.contains("여성게").and(qMember.age.gt(36)))
                                    .list(qMember);
    	*/
    	
    	/*
    	 * 반환결과가 여러건일 경우(JPQL의 NEW명령어와 같이 DTO사용)
    	 * 
    	 * 1.Projections.bean() -> setter이용
    	 * 2.Projections.fields() -> 필드직접 접근.(reflection으로 접근하므로 private이여도 접근가능)
    	 * 3.Projections.constructor() -> 생성자로 접근, 생성자 매개변수와 순서가 동일해야함.
    	 */
    	JPQLQuery<SettingInstructorDTO> query = queryFactory
			.select(Projections.bean(SettingInstructorDTO.class, 
					user.id.as("user_id"),
					user.name.as("user_name"),
					user.birthday,
					user.sex,
					user.phone,
					user.center_id.as("center_id"),
					userClassStatus.payment_class_cnt.as("payment_class_cnt"),
					userClassStatus.payment_class_status.as("payment_class_status"),
					userClassStatus.class_start_dd.as("class_start_dt"),
					userClassStatus.class_end_dd.as("class_end_dt"),
					healthClass.name.as("class_name")
			))
			.from(userClassStatus)
			.join(user).on(userClassStatus.user_id.eq(user.id))
			.join(healthClass).on(
					userClassStatus.health_class_id.eq(healthClass.id)
					.and(healthClass.center_id.eq(user.center_id))
			)
			.where(
				user.center_id.eq(center_id)
				.and(
					userClassStatus.payment_class_cnt.loe(3)
					.or(userClassStatus.class_end_dd.before(utils.currentUTCDateTime()))
					.or(userClassStatus.class_end_dd.between(utils.currentUTCDateTime(), utils.getSelectDayUTCDateTime(3)))
				)
			)
			.orderBy(
					(field.indexOf("dd") >= 0 || field.indexOf("dt") >= 0) ?  	// field에 dd & dt 가 있는지 확인 
					selectExpiredOrder(userClassStatus, field, order) :			// 있다면 Date 타입이기 때문에 해당 타입에 맞게 설정
					(field.indexOf("cnt") >= 0) ? 								// field에 cnt 가 있는지 확인
					selectExpiredOrder(userClassStatus, healthClass, field, order) :	// 있다면 Integer 타입이기 때문에 해당 타입에 맞게 설정
					selectExpiredOrder(user, userClassStatus, healthClass, field, order)
					
							
			)
			.offset((offset*limit)).limit(limit);
    	
    	return query.fetch();
		
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : Sorting을 위한 field 에 맞게 해당 Model Data를 선택 시켜 준다.
     * 2. 처리내용: String sorting 처리를 하기 위해 따로 함수를 만들어 줬다.
     * 			   TODO: 현재 특정 한 Class에만 적용이 되어 있지만 나중에는 따로 자동화 시켜줘야 한다.
     * </pre>
     *
     * @author  : moonki.cha
     * @Date   : 2019. 10. 25.
     * @Version : 
     * @Method Name: selectExpiredOrder
     * @param user
     * @param userClassStatus
     * @param healthClass
     * @param field
     * @param order
     * @return
     */
    private OrderSpecifier<String> selectExpiredOrder (QUser user, QUserHealthClassStatus userClassStatus, QHealthClass healthClass, String field, String order){
    	OrderSpecifier<String> result = null;
    	
    	// 각 Field에 맞는 OderSpecifier를 만들어 준다.
    	switch(field) {
    		// 회원 이름에 대한 field
    		case "user_name" :
    			result = commonFilter.selectOrder(order, user.name);
    			break;
    		// 수업 명에 대한 Field
    		case "class_name" :
    			result = commonFilter.selectOrder(order, healthClass.name);
    			break;
    	}
    	
    	return result; 
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : Sorting을 위한 field 에 맞게 해당 Model Data를 선택 시켜 준다.
     * 2. 처리내용: Integer sorting 처리를 하기 위해 따로 함수를 만들어 줬다.
     * 			   TODO: 현재 특정 한 Class에만 적용이 되어 있지만 나중에는 따로 자동화 시켜줘야 한다.
     * </pre>
     *
     * @author  : moonki.cha
     * @Date   : 2019. 10. 25.
     * @Version : 
     * @Method Name: selectExpiredOrder
     * @param userClassStatus
     * @param healthClass
     * @param field
     * @param order
     * @return
     */
    private OrderSpecifier<Integer> selectExpiredOrder (QUserHealthClassStatus userClassStatus, QHealthClass healthClass, String field, String order){
    	OrderSpecifier<Integer> result = null;
    	
    	// 각 Field에 맞는 OderSpecifier를 만들어 준다.
    	switch(field) {
    		// 수업 횟수에 대한 Field
    		case "payment_class_cnt" :	
    			result = commonFilter.selectOrder(order, userClassStatus.payment_class_cnt);
    			break;
    	}
    	
    	return result; 
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : Sorting을 위한 field 에 맞게 해당 Model Data를 선택 시켜 준다.
     * 2. 처리내용: Date sorting 처리를 하기 위해 따로 함수를 만들어 줬다.
     * 			   TODO: 현재 특정 한 Class에만 적용이 되어 있지만 나중에는 따로 자동화 시켜줘야 한다.
     * </pre>
     *
     * @author  : moonki.cha
     * @Date   : 2019. 10. 25.
     * @Version : 
     * @Method Name: selectExpiredOrder
     * @param userClassStatus
     * @param field
     * @param order
     * @return
     */
    private OrderSpecifier<Date> selectExpiredOrder (QUserHealthClassStatus userClassStatus, String field, String order){
    	OrderSpecifier<Date> result = null;
    	
    	// 각 Field에 맞는 OderSpecifier를 만들어 준다.
    	switch(field) {
    		// 수업 시작일에 대한 Field
    		case "class_start_dt" :
    			result = commonFilter.selectOrder(order, userClassStatus.class_start_dd);
    			break;
    		// 수업 종료일에 대한 Field
    		case "class_end_dt" :	
    			result = commonFilter.selectOrder(order, userClassStatus.class_end_dd);
    			break;
    	}
    	
    	return result; 
    }
}
