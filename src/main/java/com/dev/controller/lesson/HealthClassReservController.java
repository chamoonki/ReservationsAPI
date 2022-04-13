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

import com.dev.model.lesson.HealthClassReserv;
import com.dev.service.lesson.form.HealthClassReservService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("healthClassReserv")
public class HealthClassReservController {

	@Autowired
	private HealthClassReservService healthClassReservService;
	
	/**
    * 수업 예약 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllHealthClassReserv(HttpServletRequest request) throws Exception{
		ResponseResult result = healthClassReservService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 수업 예약 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{health_class_reserv_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getHealthClassReserv(HttpServletRequest request,
			@PathVariable("health_class_reserv_id") String health_class_reserv_id) throws Exception{
		ResponseResult result = healthClassReservService.findById(health_class_reserv_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 수업 예약 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{health_class_reserv_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteHealthClassReserv(HttpServletRequest request,
			@PathVariable("health_class_reserv_id") String health_class_reserv_id) throws Exception{
		ResponseResult result = healthClassReservService.deleteById(health_class_reserv_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 예약 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{health_class_reserv_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateHealthClassReserv(HttpServletRequest request,
			@PathVariable("health_class_reserv_id") String health_class_reserv_id,@RequestBody HealthClassReserv health_class_reserv) throws Exception{
		ResponseResult result = healthClassReservService.updateById(health_class_reserv_id, health_class_reserv);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 예약 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateHealthClassReserv(HttpServletRequest request,
			@RequestBody HealthClassReserv health_class_reserv) throws Exception{
		ResponseResult result = healthClassReservService.save(health_class_reserv);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
