package com.dev.utils.response;

/**
 * Response 모델
 * API 통신 결과값 모델
 *
 */
public class ResponseResult {

	String result_code;
	String result_msg;
	Object result_response;
	
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}
	public Object getResult_response() {
		return result_response;
	}
	public void setResult_response(Object result_response) {
		this.result_response = result_response;
	}
		
	public ResponseResult() {}
	public ResponseResult(String result_code , String result_msg , Object result_response) {
		this.result_code = result_code;
		this.result_msg = result_msg;
		this.result_response = result_response;
	}
}
