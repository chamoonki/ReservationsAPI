package com.dev.service.lesson.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dto.ScheduleClassDTO;
import com.dev.exception.ResourceNotFoundException;
import com.dev.model.lesson.HealthClassSchedule;
import com.dev.repository.lesson.HealthClassScheduleRepository;
import com.dev.service.lesson.form.HealthClassScheduleService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class HealthClassScheduleServiceImpl implements HealthClassScheduleService {

    @Autowired
    private HealthClassScheduleRepository healthClassScheduleRepository;
    
    /**
     * 수업 일정 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<HealthClassSchedule> health_class_schedule = new ArrayList<>();
			healthClassScheduleRepository.findAll().forEach(e -> health_class_schedule.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_schedule);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 수업 일정 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String health_class_schedule_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassSchedule HealthClassSchedule = healthClassScheduleRepository.findById(health_class_schedule_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClassSchedule", "health_class_schedule_id", health_class_schedule_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), HealthClassSchedule);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}
	
	/**
	 * Start & End Time을 가지고 해당 스케쥴을 가져 온다.
	 * @ return
	 */
	@Override
	public ResponseResult findBySchedule(String startDate, String endDate, String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			// 여러 값을 받아야 하기 때문에 List로 담아 준다.
			List<ScheduleClassDTO> schedule = new ArrayList<>();
			// Start Date & end Date의 경우 Date 형태로 비교 해야 하기에 DateFormat을 설정
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// Start & End Date를 parsing 해준다.
			Date _startDate = dateFormat.parse(startDate);
			Date _endDate = dateFormat.parse(endDate);
			
			// schedule 데이터를 가져와 준다.
			healthClassScheduleRepository.getSchedule(_startDate, _endDate, center_id).forEach(e -> schedule.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), schedule);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 수업 일정 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String health_class_schedule_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			healthClassScheduleRepository.deleteById(health_class_schedule_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_schedule_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 수업 일정 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String health_class_schedule_id, HealthClassSchedule health_class_schedule) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			HealthClassSchedule update_health_class_schedule = healthClassScheduleRepository.findById(health_class_schedule_id).orElseThrow(
					() -> new ResourceNotFoundException("HealthClassSchedule", "health_class_schedule_id", health_class_schedule_id));
			
			//update_health_class_schedule.setClass_date(health_class_schedule.getClass_date());
			//update_health_class_schedule.setClass_week(health_class_schedule.getClass_week());
			update_health_class_schedule.setHealth_class_id(health_class_schedule.getHealth_class_id());
			update_health_class_schedule.setMod_dd(new Date());
			update_health_class_schedule.setMod_id(health_class_schedule.getMod_id());
			update_health_class_schedule.setSchedule_status(health_class_schedule.getSchedule_status());
			
			healthClassScheduleRepository.save(update_health_class_schedule);			
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_schedule_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 수업 일정 추가
    * @return
    */
	@Override
	public ResponseResult save(HealthClassSchedule health_class_schedule, String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			// schedule에 center id를 넣어 준다.
			health_class_schedule.setCenter_id(center_id);
			// 등록 수정 date를 넣어 준다.
			health_class_schedule.setReg_dd(new Date());
			health_class_schedule.setMod_dd(new Date());
			
			// schedule을 저장 시켜 준다.
			healthClassScheduleRepository.save(health_class_schedule);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), health_class_schedule);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
}