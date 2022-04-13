package com.dev.controller.common;

import java.util.Arrays;
import java.util.stream.Collectors;

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

import com.dev.model.common.CommonCode;
import com.dev.service.common.form.CommonCodeService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.enums.code.EInstructorStatus;
import com.dev.utils.enums.code.EPaymentClassStatus;
import com.dev.utils.enums.code.EPaymentStatus;
import com.dev.utils.enums.code.EPaymentType;
import com.dev.utils.enums.code.EUserType;
import com.dev.utils.enums.impl.EnumMapperValue;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("commonCode")
public class CommonCodeController {

	@Autowired
	private CommonCodeService commonCodeService;
	
	/**
    * 공통코드 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllCommonCode(HttpServletRequest request) throws Exception{
		ResponseResult result = commonCodeService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 공통코드 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{code_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCommonCode(HttpServletRequest request,
			@PathVariable("code_id") String code_id) throws Exception{
		ResponseResult result = commonCodeService.findById(code_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 공통코드 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{code_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteCommonCode(HttpServletRequest request,
			@PathVariable("code_id") String code_id) throws Exception{
		ResponseResult result = commonCodeService.deleteById(code_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 공통코드 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{code_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateCommonCode(HttpServletRequest request,
			@PathVariable("code_id") String code_id,@RequestBody CommonCode common_code) throws Exception{
		ResponseResult result = commonCodeService.updateById(code_id, common_code);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 공통코드 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateCommonCode(HttpServletRequest request,
			@RequestBody CommonCode common_code) throws Exception{
		ResponseResult result = commonCodeService.save(common_code);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
	 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 *                                     [ Enum - Code 값 ]
	 *                                     -정적인 코드는 Enum으로 관리하고 동적 코드는 DB로 관리한다.
	 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	*/
	
	/**
    * 세팅 - 강사 상태 코드 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/getInstructorStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getInstructorStatus(HttpServletRequest request) throws Exception{
		ResponseResult result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), 
				Arrays.stream(EInstructorStatus.values())
				.map(EnumMapperValue::new)
				.collect(Collectors.toList())
				);
		
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 분류
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/getUserType", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getUserType(HttpServletRequest request) throws Exception{
		ResponseResult result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), 
				Arrays.stream(EUserType.values())
				.map(EnumMapperValue::new)
				.collect(Collectors.toList())
				);
		
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 세팅 - 결제 수업 상태
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/getPaymentClassStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getPaymentClassStatus(HttpServletRequest request) throws Exception{
		ResponseResult result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), 
				Arrays.stream(EPaymentClassStatus.values())
				.map(EnumMapperValue::new)
				.collect(Collectors.toList())
				);
		
		return ResponseUtil.getResponseEntity(result, request);
	}
		
	/**
    * 세팅 - 결제 상태
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/getPaymentStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getPaymentStatus(HttpServletRequest request) throws Exception{
		ResponseResult result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), 
				Arrays.stream(EPaymentStatus.values())
				.map(EnumMapperValue::new)
				.collect(Collectors.toList())
				);
		
		return ResponseUtil.getResponseEntity(result, request);
	}	
	
	/**
    * 세팅 - 결제 분류
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/getPaymentType", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getPaymentType(HttpServletRequest request) throws Exception{
		ResponseResult result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), 
				Arrays.stream(EPaymentType.values())
				.map(EnumMapperValue::new)
				.collect(Collectors.toList())
				);
		
		return ResponseUtil.getResponseEntity(result, request);
	}
	
}
