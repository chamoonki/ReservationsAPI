package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EPaymentStatus implements EnumMapperType {

	PAYMENT_STATUS_1("1","결제"),
	PAYMENT_STATUS_2("2","환불"),
	PAYMENT_STATUS_3("3","미결제");
	
	private String code;
	private String title;
	
	EPaymentStatus(String code, String title) {
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
