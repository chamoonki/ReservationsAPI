package com.dev.controller.manager;

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

import com.dev.model.manager.Management;
import com.dev.service.manager.form.ManagementService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("management")
public class ManagementController {

	@Autowired
	private ManagementService managementService;
	
	/**
    * 시스템 베이스 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllManagement(HttpServletRequest request) throws Exception{
		ResponseResult result = managementService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 시스템 베이스가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{management_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getManagement(HttpServletRequest request,
			@PathVariable("management_id") String management_id) throws Exception{
		ResponseResult result = managementService.findById(management_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 시스템 베이스 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{management_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteManagement(HttpServletRequest request,
			@PathVariable("management_id") String management_id) throws Exception{
		ResponseResult result = managementService.deleteById(management_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 시스템 베이스 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{management_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateManagement(HttpServletRequest request,
			@PathVariable("management_id") String management_id,@RequestBody Management management) throws Exception{
		ResponseResult result = managementService.updateById(management_id, management);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 시스템 베이스 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateManagement(HttpServletRequest request,
			@RequestBody Management management) throws Exception{
		ResponseResult result = managementService.save(management);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
