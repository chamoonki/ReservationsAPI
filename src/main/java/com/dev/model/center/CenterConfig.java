package com.dev.model.center;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 센터 운영정책
 *
 */
@Entity
@Table(name = "center_config")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterConfig {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "center_config_id", columnDefinition = "CHAR(32)")
	private String id;
	private String center_id;	
	private Integer reserv_public_unit;		//예약 가능 시간 단위
	private Integer reserv_public_time;		//예약 가능 시간
	private Integer reserv_modify_unit;		//예약 가능 시간 단위
	private Integer reserv_modify_time;		//예약 수정 가능 시간
	private Integer reserv_cancle_unit;		//예약 취소 가능 단위
	private Integer reserv_cancle_time;		//예약 취소 가능 시간
	private Integer attendance_public_unit;	//출석 가능 시간 단위
	private Integer attendance_public_time;	//출석 가능 시간
	private Integer tardy_after_unit;		//지각 가능 시간 단위
	private Integer tardy_after_time;		//지각 가능 시간
	private Integer maturity_unit;			//만기 알림 단위
	private Integer maturity_time; 			//만기 알림 시간 
	private Integer reg_id; 		
	private Date reg_dd;		
	private String mod_id; 		
	private Date mod_dd;
	
	
}
