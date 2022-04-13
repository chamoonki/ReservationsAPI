package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EPaymentClassStatus implements EnumMapperType {

	PAYMENT_CLASS_STATUS_1("1","횟수마감"),
	PAYMENT_CLASS_STATUS_2("2","기간마감"),
	PAYMENT_CLASS_STATUS_3("3","정상"),
	PAYMENT_CLASS_STATUS_4("4","횟수마감/기간정상"),
	PAYMENT_CLASS_STATUS_5("5","횟수정상/기간마감"),
	PAYMENT_CLASS_STATUS_6("6","횟수마감/기간마감");
	
	private String code;
	private String title;
	
	EPaymentClassStatus(String code, String title) {
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
