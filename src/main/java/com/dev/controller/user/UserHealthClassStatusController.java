package com.dev.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.user.UserHealthClassStatus;
import com.dev.service.user.form.UserHealthClassStatusService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("userHealthClassStatus")
public class UserHealthClassStatusController {

	@Autowired
	private UserHealthClassStatusService userHealthClassStatusService;
	
	/**
    * 사용자 수업 상태 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllUserHealthClassStatus(HttpServletRequest request) throws Exception{
		ResponseResult result = userHealthClassStatusService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 사용자 수업 상태가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{user_health_class_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getUserHealthClassStatus(HttpServletRequest request,
			@PathVariable("user_health_class_status_id") String user_health_class_status_id) throws Exception{
		ResponseResult result = userHealthClassStatusService.findById(user_health_class_status_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 사용자 수업 상태 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{user_health_class_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteUserHealthClassStatus(HttpServletRequest request,
			@PathVariable("user_health_class_status_id") String user_health_class_status_id) throws Exception{
		ResponseResult result = userHealthClassStatusService.deleteById(user_health_class_status_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 수업 상태 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{user_health_class_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateUserHealthClassStatus(HttpServletRequest request,
			@PathVariable("user_health_class_status_id") String user_health_class_status_id,
			@RequestBody UserHealthClassStatus user_health_class_status) throws Exception{
		ResponseResult result = userHealthClassStatusService.updateById(user_health_class_status_id, user_health_class_status);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 수업 상태 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveUserHealthClassStatus (HttpServletRequest request,
			@RequestBody UserHealthClassStatus user_health_class_status) throws Exception{
		ResponseResult result = userHealthClassStatusService.save(user_health_class_status);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	
}
