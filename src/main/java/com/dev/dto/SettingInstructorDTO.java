package com.dev.dto;

import java.util.Date;

import com.dev.utils.enums.code.EInstructorStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 세팅 - 강사 목록 DTO
 * <pre>
 * com.dev.dto
 * SettingInstructorDTO.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 11. 13.
 * @Version :
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SettingInstructorDTO {
	
	private String instructor_id;			//강사 아이디
	private String instructor_name;			//강사 이름
	private Integer instructor_status;		//강사 상태
	private String instructor_status_name;	//강사 상태명
	private String center_organization_id;	//조직체계 아이디
	private String oraganization_title;		//조직체계 명
	
	private Integer sex;					//성별
	private String address;					//주소
	private String birthday;				//생년월일
	private String phone;					//연락처
	private String email;					//이메일

	private Date join_date;					//입사일
	private Date leave_date;				//퇴사일
	private String instructor_desc;			//강사 비고
	
	private String reg_id;
	private String reg_name;
	private Date reg_dd;
	private String mod_id;
	private String mod_name;
	private Date mod_dd;

	public Integer getInstructor_status() {
		return instructor_status;
	}

	public void setInstructor_status(Integer instructor_status) {
		this.instructor_status = instructor_status;
		this.instructor_status_name = EInstructorStatus.getTitle(instructor_status);
	}
	
}
