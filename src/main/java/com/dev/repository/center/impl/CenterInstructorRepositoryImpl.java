package com.dev.repository.center.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.dev.dto.RegisterInstructorDTO;
import com.dev.dto.SettingInstructorDTO;
import com.dev.model.center.CenterInstructor;
import com.dev.model.center.QCenterInstructor;
import com.dev.model.center.QCenterOrganization;
import com.dev.model.common.QCommonCode;
import com.dev.model.user.QUser;
import com.dev.repository.center.custom.CustomCenterInstructorRepository;
import com.dev.utils.enums.code.EInstructorStatus;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import ch.qos.logback.core.pattern.ConverterUtil;

/**
 * 
 * <pre>
 * com.dev.repository.CenterInstructor.impl
 * HealClassRepositoryImpl.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date	: 2019. 10. 24.
 * @Version :
 */
public class CenterInstructorRepositoryImpl extends QuerydslRepositorySupport implements CustomCenterInstructorRepository {
	// JPAQueryFactory를 사용하기 위해 선언
	private final JPAQueryFactory queryFactory;
	
	// QuerydslRepositorySupport 클래스에는 기본생성자가 없음.
	// 생성 할 때 JPAQueryFactory도 주입 받는다.
    public CenterInstructorRepositoryImpl(JPAQueryFactory queryFactory) {
        super(CenterInstructor.class);
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
    public List<SettingInstructorDTO> getSettingInstructor(String center_id) throws Exception {
    	// User Table 생성
    	QUser user = QUser.user;
    	// CenterOrganization Table 생성
    	QCenterOrganization centerOrganization = QCenterOrganization.centerOrganization;
    	// CenterInstructor Table 생성
    	QCenterInstructor centerInstructor = QCenterInstructor.centerInstructor;
    	// CommonCode Table 생성
    	QCommonCode commonCode = QCommonCode.commonCode;
    	
    	/*
    	 * 반환결과가 여러건일 경우(JPQL의 NEW명령어와 같이 DTO사용)
    	 * 
    	 * 1.Projections.bean() -> setter이용
    	 * 2.Projections.fields() -> 필드직접 접근.(reflection으로 접근하므로 private이여도 접근가능)
    	 * 3.Projections.constructor() -> 생성자로 접근, 생성자 매개변수와 순서가 동일해야함.
    	 * 4.ExpressionUtils dsl에서 제공하는 util 클래스이며 서브 쿼리를 넣기위한 기능을 제공한다.    	 * 
    	 */
    	JPQLQuery<SettingInstructorDTO> query = queryFactory
			.select(Projections.bean(SettingInstructorDTO.class, 
					centerOrganization.oraganization_title,
					centerOrganization.oraganization_level,
					centerOrganization.oraganization_desc,
					centerInstructor.center_organization_id,
					centerInstructor.instructor_desc.as("instructor_desc"),
					centerInstructor.instructor_status,
					centerInstructor.join_date,
					centerInstructor.leave_date,
					user.id.as("instructor_id"),
					user.name.as("instructor_name"),
					user.phone,
					user.address,
					user.birthday,
					user.email,
					user.user_type,
					user.sex,
					ExpressionUtils.as(JPAExpressions.select(user.name).from(user).where(user.id.eq(centerInstructor.reg_id)),"reg_name"),
					user.reg_dd,
					ExpressionUtils.as(JPAExpressions.select(user.name).from(user).where(user.id.eq(centerInstructor.mod_id)),"mod_name"),
					user.mod_dd
			))
			.from(centerInstructor)
			.join(centerOrganization).on(
					centerOrganization.id.eq(centerInstructor.center_organization_id)
			)
			.join(user).on(
					user.id.eq(centerInstructor.instructor_id)
			)
			.join(commonCode).on(
					commonCode.code_id.eq("instructor_status")
			)
			.where(centerInstructor.center_id.eq(center_id));
    	
    	return query.fetch();
    }


    /**
     * 강사 수정
     */
	@Override
	public int updateInstructor(RegisterInstructorDTO registerInstructor) throws Exception {
		// User Table 생성
    	QUser user = QUser.user;
    	// CenterInstructor Table 생성
    	QCenterInstructor centerInstructor = QCenterInstructor.centerInstructor;
    	
    	// 사용자 정보 수정
    	int result = (int) queryFactory.update(user)
					    	.where(user.id.eq(registerInstructor.getInstructor_id()))
					    	.set(user.phone, registerInstructor.getPhone())
					    	.set(user.email, registerInstructor.getEmail())
					    	.set(user.address, registerInstructor.getAddress())
					    	.set(user.mod_id, registerInstructor.getMod_id())
					    	.set(user.mod_dd, new Date())
					    	.execute();
    	// 센터 인사정보 수정
    	result = (int) queryFactory.update(centerInstructor)
		    	.where(centerInstructor.instructor_id.eq(registerInstructor.getInstructor_id()))
		    	.set(centerInstructor.leave_date, registerInstructor.getLeave_date())
		    	.set(centerInstructor.center_organization_id, registerInstructor.getCenter_organization_id())
		    	.set(centerInstructor.instructor_desc, registerInstructor.getInstructor_desc())
		    	.set(centerInstructor.instructor_status, registerInstructor.getInstructor_status())
		    	.set(centerInstructor.mod_id, registerInstructor.getMod_id())
		    	.set(centerInstructor.mod_dd, new Date())
		    	.execute();
    	
    	return result;
	}
}
