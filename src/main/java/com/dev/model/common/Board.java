package com.dev.model.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시판
 * <pre>
 * com.dev.model.common
 * Board.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 10. 30.
 * @Version :
 */
@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "board_id", columnDefinition = "CHAR(32)")
	private String id; 			//아이디
	private String center_id;	//센터 아이디
	
	@Nationalized
	private String title; 		//제목
	@Lob
	@Column( length = 100000 )
	private String content; 	//내용
	private Integer board_type;	//게시판 분류 ( 1: 공지 , 2: 일반 )
	private Integer board_order;//순서
	private Integer hit;		//조회수
	private String use_yn;		//사용여부
	private String reg_id;		//등록자
	private Date reg_dd;		//등록일
	private String mod_id;		//수정자
	private Date mod_dd;		//수정일
	
}
