package com.dev.controller.lesson;

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

import com.dev.model.lesson.HealthClassType;
import com.dev.service.lesson.form.HealthClassTypeService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("healthClassType")
public class HealthClassTypeController {

	@Autowired
	private HealthClassTypeService healthClassTypeService;
	
	/**
    * 수업 카테고리 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllHealthClassType(HttpServletRequest request) throws Exception{
		ResponseResult result = healthClassTypeService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 수업 카테고리 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{health_class_type_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getHealthClassType(HttpServletRequest request,
			@PathVariable("health_class_id") String health_class_type_id) throws Exception{
		ResponseResult result = healthClassTypeService.findById(health_class_type_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 수업 카테고리 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{health_class_type_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteHealthClassType(HttpServletRequest request,
			@PathVariable("health_class_type_id") String health_class_type_id) throws Exception{
		ResponseResult result = healthClassTypeService.deleteById(health_class_type_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 카테고리 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{health_class_type_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateHealthClassType(HttpServletRequest request,
			@PathVariable("health_class_type_id") String health_class_type_id,@RequestBody HealthClassType health_class_type) throws Exception{
		ResponseResult result = healthClassTypeService.updateById(health_class_type_id, health_class_type);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 카테고리 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveHealthClassType(HttpServletRequest request,
			@RequestBody HealthClassType health_class_type) throws Exception{
		ResponseResult result = healthClassTypeService.save(health_class_type);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터별 수업 카테고리 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterHealthClassType(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = healthClassTypeService.getCenterHealthClassType(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
