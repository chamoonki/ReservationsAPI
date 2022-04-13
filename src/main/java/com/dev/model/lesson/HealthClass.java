package com.dev.model.lesson;

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
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 수업 메인 테이블
 *
 */
@Entity
@Table(name = "health_class")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "health_class_id", columnDefinition = "CHAR(32)")
    private String id;					//아이디
	
	@Nationalized
	private String name;				//이름
	private String center_id;			//센터 아이디
	private String instructor_id;		//수업 강사 아이디
	private String health_class_type_id;//수업 카테고리 아이디
	private Boolean is_use;				//수업 사용여부
	
	@Lob
	@Column( length = 100000 )
	private String remarks;				//비고
	
	//수업 제약사항
	private Integer class_session_type;		//수업 세션 분류 (1 횟수별 수업인지 , 2 기간별 수업인지 , 3 횟수/기간제 수업)
	private Integer class_cnt;				//수업 횟수
	private Integer class_cnt_payment;		//횟수별 가격
	private Integer class_session_payment;	//기간별 가격	
	private Integer class_user_max_cnt;		//총수업 인원
	private Integer class_session_month;	//기본 수업 기간(기간내에만 예약 가능하고 기간이 지났을 경우 다시 결제나 강사가 연장) 달

	//회원이 예약할 시 횟수 기준
	private Integer class_total_max_cnt;//유효기간내에 회원 예약 최대 횟수 (제한 없이도 가능)
	private Integer class_week_max_cnt;	//유효기간내에 주간 회원 예약 최대 횟수 (제한 없이도 가능)
	private Integer class_day_max_cnt;	//유효기간내에 하루 회원 예약 최대 횟수 (제한 없이도 가능)
	
	private String reg_id;			
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
