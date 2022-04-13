package com.dev.model.auth;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사용자들은 기본적으로 원장 / 강사 / 회원 디폴트로 보이게끔
 * 운영진들은 추가, 수정 가능
 *
 */
@Entity
@Table(name = "auth_group")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "auth_id", columnDefinition = "CHAR(32)")
    private String id; 			//그룹 ID
	
	@Nationalized
	private String group_name;  //그룹 명
	private String center_id;	//소속 센터
	private String user_id;		//사용자 아이디 (0일시 최초 그룹판단)
	private String reg_id; 		//그룹 생성자 아이디
	private Date reg_dd;		//그룹 생성날짜
	private String mod_id; 		//수정자 아이디
	private Date mod_dd;		//그룹 수정날짜
}
