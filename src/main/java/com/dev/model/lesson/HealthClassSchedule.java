package com.dev.model.lesson;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 수업 스케줄 테이블
 *
 */
@Entity
@Table(name = "health_class_schedule")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthClassSchedule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "health_class_schedule_id", columnDefinition = "CHAR(32)")
	private String id;
	/**
	 * 수업 ID 정보
	 */
	private String health_class_id;			// 수업 ID
	private String instructor_id;			// 수업에 포함 된 강사 ID
	private String center_id;				// 수업에 들어 있는 center 정보
	private Integer schedule_status;		// 스케줄 수업 상태 (1.정상 ,2.대기, 3.일시정지)
	
	/**
	 * 수업 설정 정보
	 */
	//@Nationalized
	private String class_week;			    // 수업 요일 (월,화,수,목,금,토,일)
	private Date class_start_dd;		// 수업 시작 날짜
	private Date class_end_dd; 			// 수업 종료 날짜
	private String class_start_time;		// 수업 시작 시간
	private String class_duration_time;		// 수업 시간 (단위: 시:분)
	private Integer class_duration_int;		// 수업 시간 (단위: 분)
	private Integer class_deduction_num;	// 수업 차감 횟수
	private Integer class_reserv_count;		// 수업 예약 정원
	
	@Column(columnDefinition = "integer default 0")
	private	 Integer class_week_interval;	// 수업 구간 반복 횟수
	
	/**
	 * 등록 & 수정 정보
	 */
	private String reg_id;			
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
}
