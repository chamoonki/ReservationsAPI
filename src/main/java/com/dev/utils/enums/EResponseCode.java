package com.dev.utils.enums;

public enum EResponseCode {
	
	SUCCESS("200","Success"),
	FIND_FILER("400", "Not Find Data"),
	FAILER("404", "Not API"),
	NOT_METHOD("405", "Not Method"),
	IP_INVIBLE("401","IP Not Public"),
	DB_EXCTION("417","DB Exction");
	
	private String code;
	private String msg;
	
	EResponseCode(String code, String msg) {
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
