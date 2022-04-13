package com.dev.controller.auth;

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

import com.dev.model.auth.AuthGroup;
import com.dev.service.auth.form.AuthGroupService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("authGroup")
public class AuthGroupController {

	@Autowired
	private AuthGroupService authGroupService;
	
   /**
    * 그룹 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllAuthGroup(HttpServletRequest request) throws Exception{
		ResponseResult result = authGroupService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 그룹 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{group_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAuthGroup(HttpServletRequest request,
			@PathVariable("group_id") String group_id) throws Exception{
		ResponseResult result = authGroupService.findById(group_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 그룹 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{group_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteAuthGroup(HttpServletRequest request,
			@PathVariable("group_id") String group_id) throws Exception{
		ResponseResult result = authGroupService.deleteById(group_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 그룹 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{group_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateAuthGroup(HttpServletRequest request,
			@PathVariable("group_id") String group_id,@RequestBody AuthGroup authGroup) throws Exception{
		ResponseResult result = authGroupService.updateById(group_id, authGroup);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 그룹 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateAuthGroup(HttpServletRequest request,
			@RequestBody AuthGroup authGroup) throws Exception{
		ResponseResult result = authGroupService.save(authGroup);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
}
