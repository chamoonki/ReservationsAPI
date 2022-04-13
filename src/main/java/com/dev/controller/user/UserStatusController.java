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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.user.UserStatus;
import com.dev.service.user.form.UserStatusService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("userStatus")
public class UserStatusController {

	@Autowired
	private UserStatusService userStatusService;
	
	/**
    * 사용자 상태 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllUserstatus(HttpServletRequest request) throws Exception{
		ResponseResult result = userStatusService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 사용자 상태가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{user_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getUserstatus(HttpServletRequest request,
			@PathVariable("user_status_id") String user_status_id) throws Exception{
		ResponseResult result = userStatusService.findById(user_status_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 사용자 상태 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{user_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteUserstatus(HttpServletRequest request,
			@PathVariable("user_status_id") String user_status_id) throws Exception{
		ResponseResult result = userStatusService.deleteById(user_status_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 상태 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{user_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateUserstatus(HttpServletRequest request,
			@PathVariable("user_status_id") String user_status_id,@RequestBody UserStatus user_status) throws Exception{
		ResponseResult result = userStatusService.updateById(user_status_id, user_status);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 상태 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveUserstatus(HttpServletRequest request,
			@RequestBody UserStatus user_status) throws Exception{
		ResponseResult result = userStatusService.save(user_status);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
