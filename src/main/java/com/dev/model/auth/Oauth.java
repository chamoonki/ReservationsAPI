package com.dev.model.auth;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 토큰 관리 테이블
 */
@Entity
@Table(name = "oauth")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Oauth {

	@Id
	@Column(name = "oauth_id")
	private String id;				//아이디
	private String access_token;
	private String token_type;
	private String refresh_token;
	private String expires_in;
	private String scope;
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
