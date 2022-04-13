package com.dev.service.lesson.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dto.SettingInstructorDTO;
import com.dev.dto.SettingHealthClassDTO;
import com.dev.exception.ResourceNotFoundException;
import com.dev.model.lesson.HealthClass;
import com.dev.repository.lesson.HealthClassRepository;
import com.dev.service.lesson.form.HealthClassService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class HealthClassServiceImpl implements HealthClassService {

    @Autowired
    private HealthClassRepository healthClassRepository;
    
    /**
     * 수업 기본정보 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<HealthClass> health_class = new ArrayList<>();
			healthClassRepository.findAll().forEach(e -> health_class.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 수업 기본정보 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String health_class_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClass HealthClass = healthClassRepository.findById(health_class_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClass", "health_class_id", health_class_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), HealthClass);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 수업 기본정보 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String health_class_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			healthClassRepository.deleteById(health_class_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 수업 기본정보 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String health_class_id, HealthClass health_class) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClass update_health_class = healthClassRepository.findById(health_class_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClass", "health_class_id", health_class_id));
			
			update_health_class.setCenter_id(health_class.getCenter_id());
			update_health_class.setClass_cnt(health_class.getClass_cnt());
			update_health_class.setClass_cnt_payment(health_class.getClass_cnt_payment());
			update_health_class.setClass_day_max_cnt(health_class.getClass_day_max_cnt());
			update_health_class.setClass_session_month(health_class.getClass_session_month());
			update_health_class.setClass_session_payment(health_class.getClass_session_payment());
			update_health_class.setClass_session_type(health_class.getClass_session_type());
			update_health_class.setClass_total_max_cnt(health_class.getClass_total_max_cnt());
			update_health_class.setHealth_class_type_id(health_class.getHealth_class_type_id());
			update_health_class.setClass_user_max_cnt(health_class.getClass_user_max_cnt());
			update_health_class.setClass_week_max_cnt(health_class.getClass_week_max_cnt());
			update_health_class.setInstructor_id(health_class.getInstructor_id());
			update_health_class.setIs_use(health_class.getIs_use());
			update_health_class.setMod_dd(new Date());
			update_health_class.setMod_id(health_class.getMod_id());
			update_health_class.setName(health_class.getName());
			update_health_class.setRemarks(health_class.getRemarks());
			
			healthClassRepository.save(update_health_class);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 수업 기본정보 추가
    * @return
    */
	@Override
	public ResponseResult save(HealthClass health_class) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			health_class.setReg_dd(new Date());
			healthClassRepository.save(health_class);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터별 수업 목록 전체 가져오기
    * @return
    */
	@Override
	public ResponseResult getCenterHealthClassList(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<HealthClass> list = healthClassRepository.getCenterHealthClassList(center_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), list);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
	 * 센터별 설정 수업 목록 전체 가져오기
	 */
	@Override
	public ResponseResult getSettingHealthClassList(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<SettingHealthClassDTO> list = new ArrayList<>();
			healthClassRepository.getSettingHealthClassList(center_id).forEach(e -> list.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), list);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

}
