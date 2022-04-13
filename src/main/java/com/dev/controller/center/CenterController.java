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

import com.dev.model.center.Center;
import com.dev.service.center.form.CenterService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("center")
public class CenterController {

	@Autowired
	private CenterService centerService;
	
	/**
    * 센터 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenter(HttpServletRequest request) throws Exception{
		ResponseResult result = centerService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 센터 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenter(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = centerService.findById(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 센터 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenter(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = centerService.deleteById(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenter(HttpServletRequest request,
			@PathVariable("center_id") String center_id,@RequestBody Center center) throws Exception{
		ResponseResult result = centerService.updateById(center_id, center);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateCenter(HttpServletRequest request,
			@RequestBody Center center) throws Exception{
		ResponseResult result = centerService.save(center);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
