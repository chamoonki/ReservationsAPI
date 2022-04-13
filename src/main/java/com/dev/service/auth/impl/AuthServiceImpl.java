package com.dev.service.auth.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.auth.Auth;
import com.dev.model.auth.Oauth;
import com.dev.model.user.User;
import com.dev.repository.auth.OauthRepository;
import com.dev.repository.user.UserRepository;
import com.dev.service.auth.form.AuthService;
import com.dev.utils.enums.EAuthCode;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.security.SecurityUtil;

/**
 * 로그인 요청한 사용자를 가져오기 위한 Service Impl
 * 
 * <pre>
 * com.dev.service.auth.impl
 * AuthServiceImpl.java
 * </pre> 
 *
 * @author  : k170750
 * @Date	: 2019. 10. 15.
 * @Version :
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OauthRepository oauthRepository;
    
    private SecurityUtil security = new SecurityUtil();
	   
	/**
	 * 사용자 로그인
	 */
	@Override
	public ResponseResult userLogin(Auth auth) throws Exception {
		
		ResponseResult result = new ResponseResult();
		Auth result_auth = new Auth();
		
		try{
			// 로그인 요청한 사용자의 ID를 가지고 DB에서 찾아 준다.
			Optional<User> op_user = userRepository.findByEmail(auth.getId());
			// 결과를 보내기 위해 설정 (Code, MSG)
			String responseCode =  EResponseCode.FIND_FILER.getCode();
			String responseMsg = EResponseCode.FIND_FILER.getMsg();
			
			// ID로 조회할 시 user가 있을 시 비밀번호를 체크한다.
			// op_user가 비어있을 때 get()을 호출 하게 되면 오류를 발생하므로 isPresent로 먼저 상위가 있을 때 체크 해준다.
			if (op_user.isPresent()) {
				
				User user = op_user.get();
				
				String password = security.decryptAES256(user.getPassword());
				
				//비밀번호가 일치할 시
				if (password.equals(auth.getPassword())) {
					
					/*
					 * 인증서버와 리소스서버가 현재 통합되어 있으므로  
					 * 회원이 있는지 여부를 찾은 다음 회원의 권한에 따라
					 * http connection 해서 토큰인증을 받고
					 * 발급 받은 토큰을 client 쪽으로 보내준다.
					 * 차후에는 토큰 인증 과 로그인 인증과는 분리되어야 한다.
					 */
					Optional<Oauth> op_user_oauth = oauthRepository.findById("dev_admin_token");
					
					result_auth.setId(auth.getId());
					result_auth.setCenter_id(auth.getCenter_id());
					result_auth.setAuth_result(EAuthCode.SUCCESS.getCode());
					result_auth.setAuth_msg(EAuthCode.SUCCESS.getCode());
					result_auth.setOauth(op_user_oauth.get());
					result_auth.setUser_type(user.getUser_type());
					
					// 정상적으로 처리 되었을 때 response 값을 200으로 세팅 한다.
					responseCode = EResponseCode.SUCCESS.getCode();
					responseMsg = EResponseCode.SUCCESS.getMsg();
				} else {
					result_auth.setAuth_result(EAuthCode.NOT_PASSWORD.getCode());
					result_auth.setAuth_msg(EAuthCode.NOT_PASSWORD.getMsg());
				}
			} else {	// ID가 없을 경우 맞는 ID가 없다고 오류를 보내 준다.
				result_auth.setAuth_result(EAuthCode.NOT_ID.getCode());
				result_auth.setAuth_msg(EAuthCode.NOT_ID.getMsg());
			}
			
			result = new ResponseResult(responseCode, responseMsg, result_auth);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		
		return result;
	}
    

}
