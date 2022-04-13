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
 * 사용자 결제 내역
 *
 */
@Entity
@Table(name = "user_payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPayment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "user_payment_id", columnDefinition = "CHAR(32)")
	private String id;
	private Integer payment_status;		//1 : 결제, 2 : 환불, 3 : 미결제 (나중에 결제 하는 경우)
	private Integer payment_type;		//1 : 수업 , 2 : 락커 , 3 : 추가 결제 등등... 차후 변경 가능
	private String payment_type_id;		//결제한 분류의 아이디 (수업 : 수업아이디 , 락커 : 락커아이디)
	private String user_id;				//사용자아이디
	private Integer class_payment;		//총 수업 금액
	private Integer payment;			//총 결제 금액
	private Integer cash;				//현금 결제 금액
	private Integer card;				//카드 결제 금액
	private String payment_instructor_id;		//결제 강사
	private String reg_id;				
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
	/**
	 * ID 제거 한 생성자
	 * @param payment_status
	 * @param payment_type
	 * @param payment_type_id
	 * @param user_id
	 * @param class_payment
	 * @param payment
	 * @param cash
	 * @param card
	 * @param payment_instructor_id
	 * @param reg_id
	 * @param reg_dd
	 * @param mod_id
	 * @param mod_dd
	 */
	public UserPayment(Integer payment_status, Integer payment_type, String payment_type_id, String user_id,
			Integer class_payment, Integer payment, Integer cash, Integer card, String payment_instructor_id,
			String reg_id, Date reg_dd, String mod_id, Date mod_dd) {
		super();
		this.payment_status = payment_status;
		this.payment_type = payment_type;
		this.payment_type_id = payment_type_id;
		this.user_id = user_id;
		this.class_payment = class_payment;
		this.payment = payment;
		this.cash = cash;
		this.card = card;
		this.payment_instructor_id = payment_instructor_id;
		this.reg_id = reg_id;
		this.reg_dd = reg_dd;
		this.mod_id = mod_id;
		this.mod_dd = mod_dd;
	}
}
