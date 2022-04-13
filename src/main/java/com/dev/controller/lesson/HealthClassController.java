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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.lesson.HealthClass;
import com.dev.service.lesson.form.HealthClassService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("healthClass")
public class HealthClassController {

	@Autowired
	private HealthClassService healthClassService;
	
	/**
    * 수업 기본정보 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllHealthClass(HttpServletRequest request) throws Exception{
		ResponseResult result = healthClassService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 수업 기본정보 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{health_class_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getHealthClass(HttpServletRequest request,
			@PathVariable("health_class_id") String health_class_id) throws Exception{
		ResponseResult result = healthClassService.findById(health_class_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 수업 기본정보 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{health_class_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteHealthClass(HttpServletRequest request,
			@PathVariable("health_class_id") String health_class_id) throws Exception{
		ResponseResult result = healthClassService.deleteById(health_class_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 기본정보 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{health_class_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateHealthClass(HttpServletRequest request,
			@PathVariable("health_class_id") String health_class_id,@RequestBody HealthClass health_class) throws Exception{
		ResponseResult result = healthClassService.updateById(health_class_id, health_class);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 기본정보 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveHealthClass(HttpServletRequest request,
			@RequestBody HealthClass health_class) throws Exception{
		ResponseResult result = healthClassService.save(health_class);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터별 수업 목록 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterHealthClassList(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = healthClassService.getCenterHealthClassList(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	
/**
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 *                                     [ 센터 관리자 - 설정 ]
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
	
	/**
    * 센터별 설정 수업 목록 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/setting/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getSettingHealthClassList(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = healthClassService.getSettingHealthClassList(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	
}
