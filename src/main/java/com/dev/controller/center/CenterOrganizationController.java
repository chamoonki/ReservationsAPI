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

import com.dev.model.center.CenterOrganization;
import com.dev.service.center.form.CenterOrganizationService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("centerOrganization")
public class CenterOrganizationController {

	@Autowired
	private CenterOrganizationService centerOrganizationService;
	
	/**
    * 전체 조직체계 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenterOrganization(HttpServletRequest request) throws Exception{
		ResponseResult result = centerOrganizationService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 조직체계  가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_organization_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterOrganization(HttpServletRequest request,
			@PathVariable("center_organization_id") String center_organization_id) throws Exception{
		ResponseResult result = centerOrganizationService.findById(center_organization_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 조직체계  삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_organization_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenterOrganization(HttpServletRequest request,
			@PathVariable("center_organization_id") String center_organization_id) throws Exception{
		ResponseResult result = centerOrganizationService.deleteById(center_organization_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 조직체계  수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_organization_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenterOrganization(HttpServletRequest request,
			@PathVariable("center_organization_id") String center_organization_id,@RequestBody CenterOrganization center_organization) throws Exception{
		ResponseResult result = centerOrganizationService.updateById(center_organization_id, center_organization);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 조직체계  추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> createCenterOrganization(HttpServletRequest request,
			@RequestBody CenterOrganization center_organization) throws Exception{
		ResponseResult result = centerOrganizationService.save(center_organization);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	
	/**
    * 센터 조직체계 목록 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterCenterOrganization(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = centerOrganizationService.getCenterCenterOrganization(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
		
}
