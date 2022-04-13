package com.dev.model.center;

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
 * 매니저먼트 (센터) 결제 상태
 *
 */
@Entity
@Table(name = "center_payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterPayment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "center_payment_id", columnDefinition = "CHAR(32)")
	private String id;
	private String center_id;		
	private Integer cash;					//현금 금액
	private Integer card;					//카드 금액
	private Integer management_grade; 		//매니지먼트 등급 1.basic 2.standard 3.primium
	private Integer payment_type;			//1 : 결제, 2 : 환불
	private String reg_id;					//생성자
	private Date reg_dd;					//생성일
	private String mod_id;					//수정자
	private Date mod_dd;					//수정일
	
		
}
