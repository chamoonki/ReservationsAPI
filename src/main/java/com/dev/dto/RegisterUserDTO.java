package com.dev.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * <pre>
 * com.dev.dto
 * RegisterUserDTO.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 10. 16.
 * @Version :
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserDTO {
	
	//User Table
	private String name;
	private Integer sex;
	private String address;
	private String birthday;
	private String phone;
	private String center_id;
	private Integer user_type;
	private String email;
	private String password;
	
	//UserHealthClassStatus Table
	private Integer payment_class_status;
	private String user_id;
	private String health_class_id;
	private String instructor_id;
	private Integer payment_class_cnt;
	private Date class_start_dd;
	private Date class_end_dd;
	
	//UserPayment Table
	private Integer payment_status;
	private Integer payment_type;
	private String payment_type_id;
	private Integer class_payment;
	private Integer payment;
	private Integer cash;
	private Integer card;
	private String payment_instructor_id;
	
	//UserStatus Table
	private Integer user_status;
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
