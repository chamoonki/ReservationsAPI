package com.dev.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 상태 (센터 원장 / 강사 분들이 관리)
 *
 */
@Entity
@Table(name = "user_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	private String user_id;
	private Integer status;	//1. 정상 / 2. 미승인  / 3. 만료 / 4. 홀딩 ....
	@Lob
	@Column( length = 100000 )
	private String remarks; //잠시 홀딩할때나 사용자의 이력을 적을때
	private String reg_id;				
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
