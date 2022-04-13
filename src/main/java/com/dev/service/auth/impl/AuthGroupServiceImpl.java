package com.dev.service.auth.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.auth.AuthGroup;
import com.dev.repository.auth.AuthGroupRepository;
import com.dev.service.auth.form.AuthGroupService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class AuthGroupServiceImpl implements AuthGroupService {

    @Autowired
    private AuthGroupRepository authGroupRepository;
    
    /**
     * 그룹 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<AuthGroup> authGroups = new ArrayList<>();
			authGroupRepository.findAll().forEach(e -> authGroups.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), authGroups);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 그룹 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String group_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			AuthGroup authGroup = authGroupRepository.findById(group_id).orElseThrow(
					() -> new ResourceNotFoundException("AuthGroup", "group_id", group_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), authGroup);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 그룹 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String group_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			authGroupRepository.deleteById(group_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), group_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 그룹 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String group_id, AuthGroup authGroup) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			AuthGroup update_authGroup = authGroupRepository.findById(group_id).orElseThrow(
					() -> new ResourceNotFoundException("AuthGroup", "group_id", group_id));
			
			update_authGroup.setGroup_name(authGroup.getGroup_name());
			update_authGroup.setMod_dd(new Date());
			update_authGroup.setMod_id(authGroup.getMod_id());
			update_authGroup.setUser_id(authGroup.getUser_id());
			
			authGroupRepository.save(update_authGroup);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), group_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 그룹 추가
    * @return
    */
	@Override
	public ResponseResult save(AuthGroup authGroup) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			authGroupRepository.save(authGroup);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), authGroup);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
