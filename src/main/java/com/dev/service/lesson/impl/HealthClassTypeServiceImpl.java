package com.dev.service.lesson.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.lesson.HealthClassType;
import com.dev.repository.lesson.HealthClassTypeRepository;
import com.dev.service.lesson.form.HealthClassTypeService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class HealthClassTypeServiceImpl implements HealthClassTypeService {

    @Autowired
    private HealthClassTypeRepository healthClassTypeRepository;
    
    /**
     * 수업 카테고리 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<HealthClassType> health_class_type = new ArrayList<>();
			healthClassTypeRepository.findAll().forEach(e -> health_class_type.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_type);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 수업 카테고리 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String health_class_type_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassType HealthClassType = healthClassTypeRepository.findById(health_class_type_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClassType", "health_class_type_id", health_class_type_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), HealthClassType);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 수업 카테고리 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String health_class_type_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			healthClassTypeRepository.deleteById(health_class_type_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_type_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 수업 카테고리 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String health_class_type_id, HealthClassType health_class_type) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			
			int update_result = healthClassTypeRepository.updateById(health_class_type);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), update_result);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 수업 카테고리 추가
    * @return
    */
	@Override
	public ResponseResult save(HealthClassType health_class_type) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			health_class_type.setReg_dd(new Date());
			healthClassTypeRepository.save(health_class_type);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_type);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터별 수업 카테고리 전체 가져오기
    * @return
    */
	@Override
	public ResponseResult getCenterHealthClassType(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<HealthClassType> list = healthClassTypeRepository.getCenterHealthClassType(center_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), list);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

}
