package com.dev.model.lesson;

import java.io.Serializable;
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
 * 수업 예약 테이블
 *
 */
@Entity
@Table(name = "health_class_reserv")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthClassReserv implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "health_class_reserv_id", columnDefinition = "CHAR(32)")
    private String id;						//예약 아이디
	private String user_id;					//에약자 아이디
	private String health_class_schedule_id;//수업 스케쥴 아이디
	private Integer reserv_status;			//예약 상태 (1.예약 / 2.에약완료 / 3.출석 / 4.미출석)
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
	
}
