package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EUserType implements EnumMapperType {

	USER_TYPE_1("1","회원"),
	USER_TYPE_2("2","강사"),
	USER_TYPE_3("3","데스크");
	
	private String code;
	private String title;
	
	EUserType(String code, String title) {
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
