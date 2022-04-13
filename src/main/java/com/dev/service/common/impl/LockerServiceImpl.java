package com.dev.service.common.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.common.Locker;
import com.dev.repository.common.LockerRepository;
import com.dev.service.common.form.LockerService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class LockerServiceImpl implements LockerService {

    @Autowired
    private LockerRepository lockerRepository;
    
    /**
     * 사물함 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<Locker> locker = new ArrayList<>();
			lockerRepository.findAll().forEach(e -> locker.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), locker);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 사물함 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String locker_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Locker Locker = lockerRepository.findById(locker_id).orElseThrow(
					() -> new ResourceNotFoundException("Locker", "locker_id", locker_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), Locker);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 사물함 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String locker_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			lockerRepository.deleteById(locker_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), locker_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 사물함 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String locker_id, Locker locker) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Locker update_locker = lockerRepository.findById(locker_id).orElseThrow(
					() -> new ResourceNotFoundException("Locker", "locker_id", locker_id));
			
			update_locker.setCenter_id(locker.getCenter_id());
			update_locker.setLocker_num(locker.getLocker_num());
			update_locker.setMod_dd(new Date());
			update_locker.setMod_id(locker.getMod_id());
			update_locker.setRemarks(locker.getRemarks());
			update_locker.setStatus(locker.getStatus());
			update_locker.setUse_end_dd(locker.getUse_end_dd());
			update_locker.setUse_start_dd(locker.getUse_start_dd());
			update_locker.setUser_id(locker.getUser_id());
			
			lockerRepository.save(update_locker);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), locker_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 사물함 추가
    * @return
    */
	@Override
	public ResponseResult save(Locker locker) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			lockerRepository.save(locker);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), locker);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
