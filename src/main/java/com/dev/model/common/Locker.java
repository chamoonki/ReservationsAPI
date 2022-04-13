package com.dev.model.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사물함
 *
 */
@Entity
@Table(name = "locker")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Locker {

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "locker_id", columnDefinition = "CHAR(32)")
	private String id;
	private Integer locker_num;		//락커 번호 (보통 센터는 락커 이름보단 번호로 메긴다)
	private String status;			//락커 상태
	private String center_id;		
	private String user_id;
	@Lob
	@Column( length = 100000 )
	private String remarks;			//비고
	private String use_start_dd;	//락커 사용 시작 기간
	private String use_end_dd;		//락커 사용 종료 기간
	private String reg_id; 		
	private Date reg_dd;		
	private String mod_id; 		
	private Date mod_dd;
	
}
