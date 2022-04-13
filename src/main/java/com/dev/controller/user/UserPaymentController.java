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

import com.dev.model.user.UserPayment;
import com.dev.service.user.form.UserPaymentService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("userPayment")
public class UserPaymentController {

	@Autowired
	private UserPaymentService userPaymentService;
	
	/**
    * 사용자 결제 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllUserPayment(HttpServletRequest request) throws Exception{
		ResponseResult result = userPaymentService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 사용자 결제가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{user_payment_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getUserPayment(HttpServletRequest request,
			@PathVariable("user_payment_id") String user_payment_id) throws Exception{
		ResponseResult result = userPaymentService.findById(user_payment_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 사용자 결제 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{user_payment_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteUserPayment(HttpServletRequest request,
			@PathVariable("user_payment_id") String user_payment_id) throws Exception{
		ResponseResult result = userPaymentService.deleteById(user_payment_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 결제 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{user_payment_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateUserPayment(HttpServletRequest request,
			@PathVariable("user_payment_id") String user_payment_id,@RequestBody UserPayment userPayment) throws Exception{
		ResponseResult result = userPaymentService.updateById(user_payment_id, userPayment);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 결제 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveUserPayment(HttpServletRequest request,
			@RequestBody UserPayment userPayment) throws Exception{
		ResponseResult result = userPaymentService.save(userPayment);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
