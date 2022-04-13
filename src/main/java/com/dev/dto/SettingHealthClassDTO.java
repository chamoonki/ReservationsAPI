package com.dev.dto;

import java.util.Date;

import com.dev.utils.enums.code.EClassSessionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * <pre>
 * com.dev.dto
 * SettingHealthClassDTO.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 10. 24.
 * @Version :
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SettingHealthClassDTO {
	
	//* 수업 카테고리 테이블 
	private String health_class_type_id;  //수업 카테고리 아이디
	private String health_class_type_name;//수업 카테고리 명
	
	//* 수업 테이블
    private String health_class_id;		//아이디
	private String health_class_name;	//이름
	private String center_id;			//센터 아이디
	private String instructor_id;		//수업 강사 아이디
	private String instructor_name;
	private Boolean is_use;				//수업 사용여부
	private String remarks;				//비고
	//수업 제약사항
	private Integer class_session_type;		//수업 세션 분류 (1 횟수별 수업인지 , 2 기간별 수업인지 , 3 횟수별 묶음 수업)
	private String class_session_type_name;	//수업 세션 분류 명
	private Integer class_cnt;				//수업 횟수
	private Integer class_cnt_payment;		//횟수별 가격
	private Integer class_session_payment;	//기간별 가격	
	private Integer class_user_max_cnt;		//총수업 인원
	private Integer class_session_day;		//기본 수업 기간(기간내에만 예약 가능하고 기간이 지났을 경우 다시 결제나 강사가 연장)
	//회원이 예약할 시 횟수 기준
	private Integer class_total_max_cnt;//유효기간내에 회원 예약 최대 횟수 (제한 없이도 가능)
	private Integer class_week_max_cnt;	//유효기간내에 주간 회원 예약 최대 횟수 (제한 없이도 가능)
	private Integer class_day_max_cnt;	//유효기간내에 하루 회원 예약 최대 횟수 (제한 없이도 가능)
	private String reg_id;			
	private String reg_name;
	private Date reg_dd;
	private String mod_id;
	private String mod_name;
	private Date mod_dd;
	
	
	public Integer getClass_session_type() {
		return class_session_type;
	}

	public void setClass_session_type(Integer class_session_type) {
		this.class_session_type = class_session_type;
		this.class_session_type_name = EClassSessionType.getTitle(class_session_type);
	}
	
	
}





