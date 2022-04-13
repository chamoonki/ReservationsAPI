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

import com.dev.model.center.CenterDirector;
import com.dev.service.center.form.CenterDirectorService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("centerDirector")
public class CenterDirectorController {

	@Autowired
	private CenterDirectorService centerDirectorService;
	
	/**
    * 전체 원장 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenterDirector(HttpServletRequest request) throws Exception{
		ResponseResult result = centerDirectorService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 원장  가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_director_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterDirector(HttpServletRequest request,
			@PathVariable("center_director_id") String center_director_id) throws Exception{
		ResponseResult result = centerDirectorService.findById(center_director_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 원장  삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_director_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenterDirector(HttpServletRequest request,
			@PathVariable("center_director_id") String center_director_id) throws Exception{
		ResponseResult result = centerDirectorService.deleteById(center_director_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 원장  수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_director_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenterDirector(HttpServletRequest request,
			@PathVariable("center_director_id") String center_director_id,@RequestBody CenterDirector center_director) throws Exception{
		ResponseResult result = centerDirectorService.updateById(center_director_id, center_director);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 원장  추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> createCenterDirector(HttpServletRequest request,
			@RequestBody CenterDirector center_director) throws Exception{
		ResponseResult result = centerDirectorService.save(center_director);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
}
