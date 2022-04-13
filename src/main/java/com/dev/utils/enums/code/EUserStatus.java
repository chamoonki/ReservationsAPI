package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EUserStatus implements EnumMapperType {

	USER_STATUS_1("1","정상"),
	USER_STATUS_2("2","미승인"),
	USER_STATUS_3("3","만료"),
	USER_STATUS_4("4","홀딩");
	
	private String code;
	private String title;
	
	EUserStatus(String code, String title) {
		this.code = code;
		this.title = title;
	}
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

}
