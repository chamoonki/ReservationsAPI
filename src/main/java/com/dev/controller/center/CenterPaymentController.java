package com.dev.controller.center;

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

import com.dev.model.center.CenterPayment;
import com.dev.service.center.form.CenterPaymentService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("centerPayment")
public class CenterPaymentController {

	@Autowired
	private CenterPaymentService centerPaymentService;
	
	/**
    * 센터 결제 이력 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenterPayment(HttpServletRequest request) throws Exception{
		ResponseResult result = centerPaymentService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 센터 결제 이력  가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_payment_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterPayment(HttpServletRequest request,
			@PathVariable("center_payment_id") String center_payment_id) throws Exception{
		ResponseResult result = centerPaymentService.findById(center_payment_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 센터 결제 이력  삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_payment_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenterPayment(HttpServletRequest request,
			@PathVariable("center_payment_id") String center_payment_id) throws Exception{
		ResponseResult result = centerPaymentService.deleteById(center_payment_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 결제 이력  수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_payment_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenterPayment(HttpServletRequest request,
			@PathVariable("center_payment_id") String center_payment_id,@RequestBody CenterPayment center_payment) throws Exception{
		ResponseResult result = centerPaymentService.updateById(center_payment_id, center_payment);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 결제 이력  추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateCenterPayment(HttpServletRequest request,
			@RequestBody CenterPayment center_payment) throws Exception{
		ResponseResult result = centerPaymentService.save(center_payment);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
}
