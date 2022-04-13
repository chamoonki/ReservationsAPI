package com.dev.service.lesson.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.lesson.HealthClassReserv;
import com.dev.repository.lesson.HealthClassReservRepository;
import com.dev.service.lesson.form.HealthClassReservService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class HealthClassReservServiceImpl implements HealthClassReservService {

    @Autowired
    private HealthClassReservRepository HealthClassReservRepository;
    
    /**
     * 수업 예약 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<HealthClassReserv> health_class_reserv = new ArrayList<>();
			HealthClassReservRepository.findAll().forEach(e -> health_class_reserv.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_reserv);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 수업 예약 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String health_class_reserv_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassReserv HealthClassReserv = HealthClassReservRepository.findById(health_class_reserv_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClassReserv", "health_class_reserv_id", health_class_reserv_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), HealthClassReserv);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 수업 예약 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String health_class_reserv_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassReservRepository.deleteById(health_class_reserv_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_reserv_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 수업 예약 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String health_class_reserv_id, HealthClassReserv health_class_reserv) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassReserv update_health_class_reserv = HealthClassReservRepository.findById(health_class_reserv_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClassReserv", "health_class_reserv_id", health_class_reserv_id));
			
			update_health_class_reserv.setHealth_class_schedule_id(health_class_reserv.getHealth_class_schedule_id());
			update_health_class_reserv.setMod_dd(new Date());
			update_health_class_reserv.setMod_id(health_class_reserv.getMod_id());
			update_health_class_reserv.setReserv_status(health_class_reserv.getReserv_status());
			update_health_class_reserv.setUser_id(health_class_reserv.getUser_id());
			
			HealthClassReservRepository.save(update_health_class_reserv);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_reserv_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 수업 예약 추가
    * @return
    */
	@Override
	public ResponseResult save(HealthClassReserv health_class_reserv) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassReservRepository.save(health_class_reserv);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_reserv);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
