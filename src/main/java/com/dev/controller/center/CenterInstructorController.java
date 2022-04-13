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

import com.dev.dto.RegisterInstructorDTO;
import com.dev.model.center.CenterInstructor;
import com.dev.service.center.form.CenterInstructorService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

/**
 * 인사정보 컨트롤러
 * <pre>
 * com.dev.controller.center
 * CenterInstructorController.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 11. 15.
 * @Version :
 */
@CrossOrigin("*")
@RestController
@RequestMapping("centerInstructor")
public class CenterInstructorController {

	@Autowired
	private CenterInstructorService centerInstructorService;
	
	/**
    * 전체 강사 인사정보 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCenterInstructor(HttpServletRequest request) throws Exception{
		ResponseResult result = centerInstructorService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 강사 인사정보  가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{center_instructor_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterInstructor(HttpServletRequest request,
			@PathVariable("center_instructor_id") String center_instructor_id) throws Exception{
		ResponseResult result = centerInstructorService.findById(center_instructor_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
 
	/**
    * 강사 인사정보  삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{center_instructor_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCenterInstructor(HttpServletRequest request,
			@PathVariable("center_instructor_id") String center_instructor_id) throws Exception{
		ResponseResult result = centerInstructorService.deleteById(center_instructor_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 강사 인사정보  수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{center_instructor_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCenterInstructor(HttpServletRequest request,
			@PathVariable("center_instructor_id") String center_instructor_id,@RequestBody CenterInstructor center_instructor) throws Exception{
		ResponseResult result = centerInstructorService.updateById(center_instructor_id, center_instructor);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 강사 인사정보  추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> createCenterInstructor(HttpServletRequest request,
			@RequestBody CenterInstructor center_instructor) throws Exception{
		ResponseResult result = centerInstructorService.save(center_instructor);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
	 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 *                                     [ 센터 관리자 - 설정 ]
	 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 */
		
	/**
    * 강사 등록
    * @return
    */
	@CrossOrigin("*")
	@PostMapping(value = "/registerInstructor")
	public ResponseEntity<ResponseResult> registerInstructor(HttpServletRequest request,
			@RequestBody RegisterInstructorDTO registerInstructor) throws Exception{
		ResponseResult result = centerInstructorService.registerInstructor(registerInstructor);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 강사 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/updateInstructor")
	public ResponseEntity<ResponseResult> updateInstructor(HttpServletRequest request,
			@RequestBody RegisterInstructorDTO registerInstructor) throws Exception{
		ResponseResult result = centerInstructorService.updateInstructor(registerInstructor);
		return ResponseUtil.getResponseEntity(result, request);
	}
		
	
	/**
    * 세팅 - 강사 목록 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/setting/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getSettingInstructor(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = centerInstructorService.getSettingInstructor(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
