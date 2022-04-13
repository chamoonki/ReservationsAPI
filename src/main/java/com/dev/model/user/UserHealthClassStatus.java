package com.dev.model.user;

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
 * 회원 수업상태
 *
 */
@Entity
@Table(name = "user_health_class_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserHealthClassStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "user_health_class_status_id", columnDefinition = "CHAR(32)")
	private String id;
	private Integer payment_class_status;	//결제 수업 상태 (횟수마감 , 기간 마감 = 종료 / 횟수 남음 , 기간 남음 = 수업)
	private String user_id;					//사용자아이디
	private String health_class_id;			//수업아이디 ( 현재 강의 수업 )
	private String instructor_id;			//담당 강사 ( 변경 가능 )
	private Integer payment_class_cnt;		//결제 수업 횟수 ( 주로 1:1 수업 때 사용하며 예약할 시 차감 )
	private Date class_start_dd;			//결제 수업 기간 시작
	private Date class_end_dd;				//결제 수업 기간 마감 수업 기간 (기간내에만 예약 가능 / 필요사항에 따라 강사가 연장가능)
	private String reg_id;				
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
	/**
	 * ID 제거 한 생성자
	 * @param payment_class_status
	 * @param user_id
	 * @param health_class_id
	 * @param instructor_id
	 * @param payment_class_cnt
	 * @param class_start_dd
	 * @param class_end_dd
	 * @param reg_id
	 * @param reg_dd
	 * @param mod_id
	 * @param mod_dd
	 */
	public UserHealthClassStatus(Integer payment_class_status, String user_id, String health_class_id,
			String instructor_id, Integer payment_class_cnt, Date class_start_dd, Date class_end_dd, String reg_id,
			Date reg_dd, String mod_id, Date mod_dd) {
		super();
		this.payment_class_status = payment_class_status;
		this.user_id = user_id;
		this.health_class_id = health_class_id;
		this.instructor_id = instructor_id;
		this.payment_class_cnt = payment_class_cnt;
		this.class_start_dd = class_start_dd;
		this.class_end_dd = class_end_dd;
		this.reg_id = reg_id;
		this.reg_dd = reg_dd;
		this.mod_id = mod_id;
		this.mod_dd = mod_dd;
	}
	
	
	
}
