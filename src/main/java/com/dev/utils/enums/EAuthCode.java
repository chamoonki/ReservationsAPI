package com.dev.utils.enums;

public enum EAuthCode {
	
	SUCCESS("1","Success"),
	NOT_ID("2","아이디가 존재하지 않습니다."),
	NOT_PASSWORD("3","패스워드가 일치하지 않습니다.");
	
	private String code;
	private String msg;
	
	EAuthCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
