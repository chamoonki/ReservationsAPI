package com.dev.utils.enums.code;

import com.dev.utils.enums.form.EnumMapperType;

public enum EInstructorStatus implements EnumMapperType {

	INSTRUCTOR_STATUS_1("1","근무"),
	INSTRUCTOR_STATUS_2("2","퇴사"),
	INSTRUCTOR_STATUS_3("3","정지");
	
	private String code;
	private String title;
	
	EInstructorStatus(String code, String title) {
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
	    	result = EInstructorStatus.INSTRUCTOR_STATUS_1.getTitle();
	    	break;
	    case 2:
	    	result = EInstructorStatus.INSTRUCTOR_STATUS_2.getTitle();
	    	break;
	    case 3:
	    	result = EInstructorStatus.INSTRUCTOR_STATUS_3.getTitle();
	    	break;
	    default:
	      break;
	    }
	    return result;
	 }
}
