package com.dev.model.manager;

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
 * 프로그램 사용 등급 메인 테이블
 */
@Entity
@Table(name = "management")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Management implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "management_id", columnDefinition = "CHAR(32)")
	private String id;				//아이디
	
	@Nationalized
	private String name;			//이름
	private String grad;			//등급 1.basic 2.standard 3.primium
	private Integer user_cnt;		//사용 가능 회원수
	private Integer instructor_cnt;	//사용 가능 강사수
	private Integer payment;		//한달 이용 가격
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
