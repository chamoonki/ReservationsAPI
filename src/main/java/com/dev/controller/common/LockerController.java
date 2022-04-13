package com.dev.controller.common;

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

import com.dev.model.common.Locker;
import com.dev.service.common.form.LockerService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("locker")
public class LockerController {

	@Autowired
	private LockerService lockerService;
	
	/**
    * 사물함 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllLocker(HttpServletRequest request) throws Exception{
		ResponseResult result = lockerService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 사물함가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{locker_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getLocker(HttpServletRequest request,
			@PathVariable("locker_id") String locker_id) throws Exception{
		ResponseResult result = lockerService.findById(locker_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 사물함 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{locker_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteLocker(HttpServletRequest request,
			@PathVariable("locker_id") String locker_id) throws Exception{
		ResponseResult result = lockerService.deleteById(locker_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사물함 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{locker_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateLocker(HttpServletRequest request,
			@PathVariable("locker_id") String locker_id,@RequestBody Locker locker) throws Exception{
		ResponseResult result = lockerService.updateById(locker_id, locker);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사물함 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateLocker(HttpServletRequest request,
			@RequestBody Locker locker) throws Exception{
		ResponseResult result = lockerService.save(locker);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
