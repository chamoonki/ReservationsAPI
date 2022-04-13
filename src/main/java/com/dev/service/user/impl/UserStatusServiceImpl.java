package com.dev.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.user.UserStatus;
import com.dev.repository.user.UserStatusRepository;
import com.dev.service.user.form.UserStatusService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    private UserStatusRepository userStatusRepository;
    
    /**
     * 사용자 상태 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<UserStatus> user_statuss = new ArrayList<>();
			userStatusRepository.findAll().forEach(e -> user_statuss.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_statuss);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 사용자 상태 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String user_status_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			UserStatus user_status = userStatusRepository.findById(user_status_id).orElseThrow(
					() -> new ResourceNotFoundException("UserStatus", "user_status_id", user_status_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_status);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 사용자 상태 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String user_status_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			userStatusRepository.deleteById(user_status_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_status_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 사용자 상태 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String user_status_id, UserStatus user_status) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			UserStatus update_user_status = userStatusRepository.findById(user_status_id).orElseThrow(
					() -> new ResourceNotFoundException("UserStatus", "user_status_id", user_status_id));
			
			update_user_status.setMod_dd(new Date());
			update_user_status.setMod_id(user_status.getMod_id());
			update_user_status.setRemarks(user_status.getRemarks());
			update_user_status.setStatus(user_status.getStatus());
			update_user_status.setUser_id(user_status.getUser_id());
			
			userStatusRepository.save(update_user_status);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_status_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 사용자 상태 추가
    * @return
    */
	@Override
	public ResponseResult save(UserStatus user_status) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			userStatusRepository.save(user_status);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_status);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
