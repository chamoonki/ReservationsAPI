package com.dev.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.auth.Auth;
import com.dev.service.auth.form.AuthService;
import com.dev.service.auth.form.OauthService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

/**
 * 회원 & 센터장 & 관리자가 로그인을 하기 위한 Class
 * 
 * <pre>
 * com.dev.controller.auth
 * AuthController.java
 * </pre>
 *
 * @author  : mk.ddiction
 * @Date	: 2019. 10. 15.
 * @Version :
 */
@CrossOrigin("*")
@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private OauthService oAuthService; 
	
	/**
	 * 사용자 로그인
	 *
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 사용자 로그인 정보 확인
	 * 2. 처리내용: 사용자가 ID & PASSWORD를 입력 하여 DB에서 맞는 데이터 인지를 확인 한다. 
	 * </pre>
	 *
	 * @author  : mk.ddiction
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: userLogin
	 * @param request
	 * @param auth
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin("*")
	@PostMapping(value = "/userLogin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> userLogin(HttpServletRequest request,
			@RequestBody Auth auth) throws Exception{
		ResponseResult result = authService.userLogin(auth);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : Access-token 정보 저장
	 * 2. 처리내용: Access-token에 대한 정보를 GUI Store에 가지고 있기 위해 DB에서 확인 한다.
	 * </pre>
	 *
	 * @author  : k170750
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: getAuthCheck
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin("*")
	@GetMapping(value = "/authData", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult>  getAuthCheck(HttpServletRequest request, 
			@RequestHeader(value="authorization") String headerToken) throws Exception {
		
		// token을 이용하여 정보를 가져온다.
		ResponseResult result = oAuthService.findByToken(headerToken.split(" ")[1]);		
		return ResponseUtil.getResponseEntity(result, request);
	}
}
