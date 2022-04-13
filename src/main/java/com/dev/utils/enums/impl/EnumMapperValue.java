package com.dev.utils.enums.impl;

import com.dev.utils.enums.form.EnumMapperType;

public class EnumMapperValue {
		
	private String code;
	private String title;
	
	public EnumMapperValue(EnumMapperType enumMapperType) {
		code = enumMapperType.getCode();
		title = enumMapperType.getTitle();
	}
	
	public String getCode() {
		return code;
	}
	
	public String getTtile() {
		return title;
	}
	
	@Override
	public String toString() {
		return "{" +
				"code='"+code+'\''+
				", title='"+title+'\''+
				'}';
	}
	
}
