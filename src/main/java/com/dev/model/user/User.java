package com.dev.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사용자 기본정보
 *
 */
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	private String id;			//유저아이디는 이메일
	private String password;
	
	@Nationalized
	private String name;
	private String phone;
	private String address;
	private Integer sex;
	private String birthday;
	private String email;
	private String center_id;
	private Integer user_type;
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
