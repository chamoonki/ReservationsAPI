package com.dev.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * <pre>
 * com.dev.dto
 * RegisteInstructorDTO.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 10. 16.
 * @Version :
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterInstructorDTO {
	
	//User Table
	private String user_id;
	private String name;
	private Integer sex;
	private String address;
	private String birthday;
	private String phone;
	private String center_id;
	private Integer user_type;
	private String email;
	private String password;
	
	//CenterInstructor
	private String instructor_id;				//강사 아이디
	private String center_organization_id;		//조직체계 아이디
	private Integer instructor_status;			//강사 상태
	private String instructor_desc;				//강사 비고
	private Date join_date;						//입사일
	private Date leave_date;					//퇴사일
	
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
