package com.dev.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * client 로그인 인증
 * @author 김민기
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auth {

	private String id;
	private String password;
	private Integer user_type;
	private String center_id;
	private String auth_result;
	private String auth_msg;
	private Oauth oauth;
	
}
