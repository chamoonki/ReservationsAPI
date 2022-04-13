package com.dev.service.auth.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.auth.Oauth;
import com.dev.model.user.User;
import com.dev.repository.auth.OauthRepository;
import com.dev.service.auth.form.OauthService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class OauthServiceImpl implements OauthService {

    @Autowired
    private OauthRepository oauthRepository;
    
    
    /**
	 * <pre>
	 * 1. 개요 : oAuth에 대한 모든 정보를 가져온다. 
	 * 2. 처리내용: oAuth에 대한 모든 정보를 가져온다.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: findByToken
	 * @param token
	 * @return
	 * @throws Eception
	 */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<Oauth> oauths = new ArrayList<>();
			oauthRepository.findAll().forEach(e -> oauths.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), oauths);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 특정 ID에 속한 oAuth를 가져온다. 
	 * 2. 처리내용: 특정 ID를 이용하여 해당 oAuth 정보를 DB에서 가져온다.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: findByToken
	 * @param token
	 * @return
	 * @throws Eception
	 */
	@Override
	public ResponseResult findById(String oauth_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Oauth Oauth = oauthRepository.findById(oauth_id).orElseThrow(
					() -> new ResourceNotFoundException("Oauth", "oauth_id", oauth_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), Oauth);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}
	
	/**
	 * <pre>
	 * 1. 개요 :  access-token으로 Oauth 정보를 가져온다.
	 * 2. 처리내용: access-token으로 Oauth에 대한 정보를 가져 오도록 한다.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: findByToken
	 * @param token
	 * @return
	 * @throws Eception
	 */
	@Override
	public ResponseResult findByToken(String token) throws Exception {
		 ResponseResult result = new ResponseResult();
		 
		 try {
			 // access-token을 가지고 허용 가능한 token인지 확인
			 Oauth oAuth = oauthRepository.findByToken(token);
			 
			 // 결과가 있다면 데이터를 넘겨 준다.
			 if(oAuth != null) {
				 result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), oAuth);
			 }
		 }catch(Exception e) {
			 result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
			 throw new Exception("DB exception", e);
		 }
		 
		 return result;
	}

	/**
	 * <pre>
	 * 1. 개요 : auth ID로 oAuth Data를 삭제 한다. 
	 * 2. 처리내용: auth ID를 받아 해당 oAuth Data를 삭제 시켜 준다.
	 * </pre>
	 *
	 * @author  : mk.ddiction
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: deleteById
	 * @param oauth_id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseResult deleteById(String oauth_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			oauthRepository.deleteById(oauth_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), oauth_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
	 * <pre>
	 * 1. 개요 : auth ID로 oAuth Data를 업데이트 한다. 
	 * 2. 처리내용: auth ID를 받아 해당 oAuth Data를 업데이트 시켜 준다.
	 * </pre>
	 *
	 * @author  : mk.ddiction
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: deleteById
	 * @param oauth_id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseResult updateById(String oauth_id, Oauth oauth) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Oauth update_oauth = oauthRepository.findById(oauth_id).orElseThrow(
					() -> new ResourceNotFoundException("Oauth", "oauth_id", oauth_id));
			
			update_oauth.setAccess_token(oauth.getAccess_token());
			update_oauth.setExpires_in(oauth.getExpires_in());
			update_oauth.setId(oauth.getId());
			update_oauth.setMod_dd(new Date());
			update_oauth.setMod_id(oauth.getMod_id());
			update_oauth.setRefresh_token(oauth.getRefresh_token());
			update_oauth.setScope(oauth.getScope());
			update_oauth.setToken_type(oauth.getToken_type());
			
			oauthRepository.save(update_oauth);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), oauth_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : auth 정보를 저장 해 준다. 
	 * 2. 처리내용: DB에 oAuth 정보를 저장 시켜 준다.
	 * </pre>
	 *
	 * @author  : mk.ddiction
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: deleteById
	 * @param oauth_id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseResult save(Oauth oauth) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			oauthRepository.save(oauth);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), oauth);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
