package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EPaymentType implements EnumMapperType {

	PAYMENT_TYPE_1("1","수업 결제"),
	PAYMENT_TYPE_2("2","추가 결제"),
	PAYMENT_TYPE_3("3","락커 결제"),
	PAYMENT_TYPE_4("4","수업/락커 결제")	;
	
	private String code;
	private String title;
	
	EPaymentType(String code, String title) {
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
