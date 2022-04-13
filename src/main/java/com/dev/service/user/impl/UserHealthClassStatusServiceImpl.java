package com.dev.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.user.UserHealthClassStatus;
import com.dev.repository.user.UserHealthClassStatusRepository;
import com.dev.service.user.form.UserHealthClassStatusService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class UserHealthClassStatusServiceImpl implements UserHealthClassStatusService {

    @Autowired
    private UserHealthClassStatusRepository userHealthClassStatusRepository;
    
    /**
     * 사용자 수업 상태 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<UserHealthClassStatus> user_health_class_statuss = new ArrayList<>();
			userHealthClassStatusRepository.findAll().forEach(e -> user_health_class_statuss.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_health_class_statuss);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 사용자 수업 상태 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String user_health_class_status_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			UserHealthClassStatus user_health_class_status = userHealthClassStatusRepository.findById(user_health_class_status_id).orElseThrow(
					() -> new ResourceNotFoundException("UserHealthClassStatus", "user_health_class_status_id", user_health_class_status_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_health_class_status);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 사용자 수업 상태 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String user_health_class_status_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			userHealthClassStatusRepository.deleteById(user_health_class_status_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_health_class_status_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 사용자 수업 상태 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String user_health_class_status_id, UserHealthClassStatus user_health_class_status) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			UserHealthClassStatus update_user_health_class_status = userHealthClassStatusRepository.findById(user_health_class_status_id).orElseThrow(
					() -> new ResourceNotFoundException("UserHealthClassStatus", "user_health_class_status_id", user_health_class_status_id));

			update_user_health_class_status.setClass_end_dd(user_health_class_status.getClass_end_dd());
			update_user_health_class_status.setClass_start_dd(user_health_class_status.getClass_start_dd());
			update_user_health_class_status.setHealth_class_id(user_health_class_status.getHealth_class_id());
			update_user_health_class_status.setMod_dd(new Date());
			update_user_health_class_status.setMod_id(user_health_class_status.getMod_id());
			update_user_health_class_status.setPayment_class_cnt(user_health_class_status.getPayment_class_cnt());
			update_user_health_class_status.setPayment_class_status(user_health_class_status.getPayment_class_status());
			update_user_health_class_status.setUser_id(user_health_class_status.getUser_id());
			
			userHealthClassStatusRepository.save(update_user_health_class_status);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_health_class_status_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 사용자 수업 상태 추가
    * @return
    */
	@Override
	public ResponseResult save(UserHealthClassStatus user_health_class_status) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			userHealthClassStatusRepository.save(user_health_class_status);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_health_class_status);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
