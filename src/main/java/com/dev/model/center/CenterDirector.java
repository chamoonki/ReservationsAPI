package com.dev.model.center;

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
 * 원장 정보 (별도로 관리)
 *
 */
@Entity
@Table(name = "center_director")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterDirector implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "director_id")
	private String id;			//아이디
	private String password;	//비밀번호
	
	@Nationalized
	private String name;		//이름
	private String sex;			//성별
	private String birthday;	//생년월일
	private String phone;		//개인 연락처
	private String email;		//이메일
	private Date reg_dd;		//생성일
	private String mod_id;		//수정자
	private Date mod_dd;		//수정일
	
}
