package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EClassSessionType implements EnumMapperType {

	CLASS_SESSION_TYPE_1("1","횟수"),
	CLASS_SESSION_TYPE_2("2","기간"),
	CLASS_SESSION_TYPE_3("3","횟수/기간");
	
	private String code;
	private String title;
	
	EClassSessionType(String code, String title) {
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
	
	public static String getTitle(Integer code) {
		String result = "";
		code = code == null ? 0 : code;
		
	    switch (code) {
	    case 1:
	    	result = EClassSessionType.CLASS_SESSION_TYPE_1.getTitle();
	    	break;
	    case 2:
	    	result = EClassSessionType.CLASS_SESSION_TYPE_2.getTitle();
	    	break;
	    case 3:
	    	result = EClassSessionType.CLASS_SESSION_TYPE_3.getTitle();
	    	break;
	    default:
	      break;
	    }
	    return result;
	 }
}
