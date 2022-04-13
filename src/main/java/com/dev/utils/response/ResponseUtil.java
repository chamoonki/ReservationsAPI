package com.dev.utils.response;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dev.utils.enums.EResponseCode;

public class ResponseUtil {
	
	/**
	 * response 결과값 보내기
	 * @param result
	 * @param request
	 * @return
	 */
	public static ResponseEntity<ResponseResult> getResponseEntity (ResponseResult result, HttpServletRequest request) {
		if (result.getResult_code().equals(EResponseCode.SUCCESS.getCode())) {
			return new ResponseEntity<ResponseResult>(result, HttpStatus.OK);
		} else if (result.getResult_code().equals(EResponseCode.DB_EXCTION.getCode())) {
			return new ResponseEntity<ResponseResult>(result, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<ResponseResult>(result, HttpStatus.BAD_REQUEST);
	}
}
