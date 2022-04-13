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

import com.dev.model.center.CenterStatus;
import com.dev.service.center.form.CenterStatusService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("centerStatus")
public class CenterStatusController {

	@Autowired
	private CenterStatusService centerStatusService;
	
	/**
    * 센터 상태 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenterStatus(HttpServletRequest request) throws Exception{
		ResponseResult result = centerStatusService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 센터 상태  가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterStatus(HttpServletRequest request,
			@PathVariable("center_status_id") String center_status_id) throws Exception{
		ResponseResult result = centerStatusService.findById(center_status_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 센터 상태  삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenterStatus(HttpServletRequest request,
			@PathVariable("center_status_id") String center_status_id) throws Exception{
		ResponseResult result = centerStatusService.deleteById(center_status_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 상태  수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_status_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenterStatus(HttpServletRequest request,
			@PathVariable("center_status_id") String center_status_id,@RequestBody CenterStatus center_status) throws Exception{
		ResponseResult result = centerStatusService.updateById(center_status_id, center_status);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 상태  추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateCenterStatus(HttpServletRequest request,
			@RequestBody CenterStatus center_status) throws Exception{
		ResponseResult result = centerStatusService.save(center_status);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
}
