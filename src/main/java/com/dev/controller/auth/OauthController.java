package com.dev.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.dev.model.auth.Oauth;
import com.dev.service.auth.form.OauthService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("oauthCustom")
public class OauthController {

	@Autowired
	private OauthService oauthService;
	
	private static String public_ip = "0:0:0:0:0:0:0:1";
	
	/**
    * Oauth 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllOauth(HttpServletRequest request) throws Exception{
		if (!request.getRemoteAddr().equals(public_ip)) {
			//인증 분리될때 까지 ip 체크 (client에서만 api 호출 가능)
			ResponseResult result = new ResponseResult();
			result.setResult_msg(EResponseCode.IP_INVIBLE.getMsg());
			result.setResult_code(EResponseCode.IP_INVIBLE.getCode());
			return new ResponseEntity<ResponseResult>(result, HttpStatus.UNAUTHORIZED);
		}
		
		ResponseResult result = oauthService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 Oauth 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{oauth_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getOauth(HttpServletRequest request,
			@PathVariable("oauth_id") String oauth_id) throws Exception{
		
		if (!request.getRemoteAddr().equals(public_ip)) {
			//인증 분리될때 까지 ip 체크 (client에서만 api 호출 가능)
			ResponseResult result = new ResponseResult();
			result.setResult_msg(EResponseCode.IP_INVIBLE.getMsg());
			result.setResult_code(EResponseCode.IP_INVIBLE.getCode());
			return new ResponseEntity<ResponseResult>(result, HttpStatus.UNAUTHORIZED);
		}
		
		ResponseResult result = oauthService.findById(oauth_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * Oauth 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{oauth_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteOauth(HttpServletRequest request,
			@PathVariable("oauth_id") String oauth_id) throws Exception{
		
		if (!request.getRemoteAddr().equals(public_ip)) {
			//인증 분리될때 까지 ip 체크 (client에서만 api 호출 가능)
			ResponseResult result = new ResponseResult();
			result.setResult_msg(EResponseCode.IP_INVIBLE.getMsg());
			result.setResult_code(EResponseCode.IP_INVIBLE.getCode());
			return new ResponseEntity<ResponseResult>(result, HttpStatus.UNAUTHORIZED);
		}
		
		ResponseResult result = oauthService.deleteById(oauth_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * Oauth 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{oauth_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateOauth(HttpServletRequest request,
			@PathVariable("oauth_id") String oauth_id,@RequestBody Oauth oauth) throws Exception{
		
		if (!request.getRemoteAddr().equals(public_ip)) {
			//인증 분리될때 까지 ip 체크 (client에서만 api 호출 가능)
			ResponseResult result = new ResponseResult();
			result.setResult_msg(EResponseCode.IP_INVIBLE.getMsg());
			result.setResult_code(EResponseCode.IP_INVIBLE.getCode());
			return new ResponseEntity<ResponseResult>(result, HttpStatus.UNAUTHORIZED);
		}
		
		ResponseResult result = oauthService.updateById(oauth_id, oauth);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * Oauth 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveOauth(HttpServletRequest request,
			@RequestBody Oauth oauth) throws Exception{
		
		if (!request.getRemoteAddr().equals(public_ip)) {
			//인증 분리될때 까지 ip 체크 (client에서만 api 호출 가능)
			ResponseResult result = new ResponseResult();
			result.setResult_msg(EResponseCode.IP_INVIBLE.getMsg());
			result.setResult_code(EResponseCode.IP_INVIBLE.getCode());
			return new ResponseEntity<ResponseResult>(result, HttpStatus.UNAUTHORIZED);
		}
		
		ResponseResult result = oauthService.save(oauth);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
