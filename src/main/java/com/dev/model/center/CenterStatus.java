package com.dev.model.center;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *	센터 시스템  사용 상태 (등급별 기능 관리)
 */
@Entity
@Table(name = "center_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "center_id")
	private String center_id;
	private String management_id;			
	private String management_start_dd;		//매니지먼트 사용 가능 시작 날짜
	private String management_end_dd;		//매니지먼트 사용 가능 마감 날짜
	private String status;					//1 사용중 , 2 임시중지 , 3 탈퇴
	private String reg_id;					//생성자
	private Date reg_dd;					//생성일
	private String mod_id;					//수정자
	private Date mod_dd;					//수정일
}
