package com.dev.service.user.form;

import java.util.Map;

import com.dev.dto.RegisterUserDTO;
import com.dev.dto.SearchGridDTO;
import com.dev.model.user.User;
import com.dev.utils.response.ResponseResult;

public interface UserService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String user_id) throws Exception;
	ResponseResult deleteById(String user_id) throws Exception;
	ResponseResult updateById(String user_id, User user) throws Exception;
	ResponseResult save(User user) throws Exception;
	
	/**
	 * 
	 * <pre>
	 *  1. 개요: 유효 회원 목록 가져오기 Service
	 *  2. 처리내용: 현재 수강 중 & 결제를 한 회원 목록을 가져온다.
	 * </pre>
	 *
	 * @author: moonki.cha
	 * @date : 2019. 10. 29.
	 * @version: 
	 * @method name: getChargedUser
	 * @param center_id
	 * @param search
	 * @return
	 * @throws Exception
	 */
	ResponseResult getChargedUser(String center_id, SearchGridDTO search) throws Exception;
	
	/**
	 * 
	 * <pre>
	 *  1. 개요: 만기 회원 목록 가져오기 Service
	 *  2. 처리내용: 결제 만기 되어 가는 회원의 목록을 가져 온다.
	 * </pre>
	 *
	 * @author: moonki.cha
	 * @date : 2019. 10. 29.
	 * @version: 
	 * @method name: getExpiredUser
	 * @param center_id
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	ResponseResult getExpiredUser(String center_id, SearchGridDTO search) throws Exception;
	
	//회원 등록 관련
	ResponseResult getInstructorUser(String center_id) throws Exception;
	ResponseResult registerUser(RegisterUserDTO registerUser) throws Exception;
}
