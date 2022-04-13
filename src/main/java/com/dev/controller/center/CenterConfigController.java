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

import com.dev.model.center.CenterConfig;
import com.dev.service.center.form.CenterConfigService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("centerConfig")
public class CenterConfigController {

	@Autowired
	private CenterConfigService centerConfigService;
	
	/**
    * 센터 운영 정책  운영 정책 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenterConfig(HttpServletRequest request) throws Exception{
		ResponseResult result = centerConfigService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 센터 운영 정책  가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_config_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterConfig(HttpServletRequest request,
			@PathVariable("center_config_id") String center_config_id) throws Exception{
		ResponseResult result = centerConfigService.findById(center_config_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 센터 운영 정책  삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_config_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenterConfig(HttpServletRequest request,
			@PathVariable("center_config_id") String center_config_id) throws Exception{
		ResponseResult result = centerConfigService.deleteById(center_config_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 운영 정책  수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_config_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenterConfig(HttpServletRequest request,
			@PathVariable("center_config_id") String center_config_id,@RequestBody CenterConfig center_config) throws Exception{
		ResponseResult result = centerConfigService.updateById(center_config_id, center_config);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 운영 정책  추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveCenterConfig(HttpServletRequest request,
			@RequestBody CenterConfig center_config) throws Exception{
		ResponseResult result = centerConfigService.save(center_config);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터별 센터 운영 정책 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterCenterConfig(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = centerConfigService.getCenterCenterConfig(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	
}
