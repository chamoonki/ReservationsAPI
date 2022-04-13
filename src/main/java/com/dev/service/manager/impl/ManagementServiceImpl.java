package com.dev.service.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.manager.Management;
import com.dev.repository.manager.ManagementRepository;
import com.dev.service.manager.form.ManagementService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    private ManagementRepository managementRepository;
    
    /**
     * 시스템 베이스 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<Management> managements = new ArrayList<>();
			managementRepository.findAll().forEach(e -> managements.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), managements);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 시스템 베이스 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String management_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Management management = managementRepository.findById(management_id).orElseThrow(
					() -> new ResourceNotFoundException("Management", "management_id", management_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), management);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 시스템 베이스 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String management_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			managementRepository.deleteById(management_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), management_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 시스템 베이스 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String management_id, Management management) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Management update_Management = managementRepository.findById(management_id).orElseThrow(
					() -> new ResourceNotFoundException("Management", "management_id", management_id));
			
			update_Management.setGrad(management.getGrad());
			update_Management.setInstructor_cnt(management.getInstructor_cnt());
			update_Management.setMod_dd(new Date());
			update_Management.setMod_id(management.getMod_id());
			update_Management.setName(management.getName());
			update_Management.setPayment(management.getPayment());
			update_Management.setUser_cnt(management.getUser_cnt());
				
			managementRepository.save(update_Management);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), management_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 시스템 베이스 추가
    * @return
    */
	@Override
	public ResponseResult save(Management management) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			managementRepository.save(management);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), management);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
