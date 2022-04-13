package com.dev.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberUserDTO {
	// 회원 ID
	private String user_id;
	// 회원 이름
	private String user_name;
	// 회원 생년월일
	private String birthday;
	// 회원 성별
	private Integer sex;
	// 회원 전화번호 (휴대전화 번호)
	private String phone;
	// 회원이 속한 Center ID
	private String center_id;
	// 회원이 이용 중인 수업에 대한 현재 수업 횟수
	private Integer payment_class_cnt;
	// 회원이 이용 중인 수업에 대한 현재 상태
	private Integer payment_class_status;
	// 회원이 이용 중인 수업에 대한 시작 Datetime
	private Date class_start_dt;
	// 회원이 이용 중인 수업에 대한 종료 Datetime
	private Date class_end_dt;
	// 회원이 이용 중인 수업 이름
	private String class_name;
}
