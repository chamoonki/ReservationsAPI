package com.dev.service.auth.form;

import com.dev.model.auth.Oauth;
import com.dev.utils.response.ResponseResult;

public interface OauthService {
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : oAuth에 대한 모든 정보를 가져온다. 
	 * 2. 처리내용: oAuth에 대한 모든 정보를 가져온다.
	 * </pre>
	 *
	 * @author  : mk.ddiction
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: findAll
	 * @return
	 * @throws Exception
	 */
	ResponseResult findAll() throws Exception;
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 특정 ID에 속한 oAuth를 가져온다. 
	 * 2. 처리내용: 특정 ID를 이용하여 해당 oAuth 정보를 DB에서 가져온다.
	 * </pre>
	 *
	 * @author  : mk.ddiction
	 * @Date   : 2019. 10. 16.
	 * @Version : 
	 * @Method Name: findById
	 * @param oauth_id
	 * @return
	 * @throws Exception
	 */
	ResponseResult findById(String oauth_id) throws Exception;
	
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
	 * @throws Exception
	 */
	ResponseResult findByToken(String token) throws Exception;
	
	/**
	 * 
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
	ResponseResult deleteById(String oauth_id) throws Exception;
	
	/**
	 * 
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
	ResponseResult updateById(String oauth_id, Oauth oauth) throws Exception;
	
	/**
	 * 
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
	ResponseResult save(Oauth oauth) throws Exception;

}
