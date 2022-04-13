package com.dev.service.lesson.form;

import com.dev.dto.ScheduleClassDTO;
import com.dev.model.lesson.HealthClassSchedule;
import com.dev.utils.response.ResponseResult;

public interface HealthClassScheduleService {
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 스케쥴 전체 정보를 가져온다. 
	 * 2. 처리내용: 스케쥴에 대한 전체 정보를 가져온다.
	 * </pre>
	 *
	 * @author  : MIN. KI. KIM
	 * @Date   : 2019. 11. 26.
	 * @Version : 
	 * @Method Name: findAll
	 * @return
	 * @throws Exception
	 */
	ResponseResult findAll() throws Exception;
	ResponseResult findById(String health_class_schedule_id) throws Exception;
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 선택 한 달에 대한 Schedule 정보를 가져온다. 
	 * 2. 처리내용: Start & End Time을 가지고 센터 별 스케쥴 정보를 가져온다.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 11. 26.
	 * @Version : 
	 * @Method Name: findBySchedule
	 * @param search
	 * @return
	 * @throws Exception
	 */
	ResponseResult findBySchedule(String startDate, String endDate, String center_id) throws Exception;
	
	ResponseResult deleteById(String health_class_schedule_id) throws Exception;
	ResponseResult updateById(String health_class_schedule_id, HealthClassSchedule health_class_schedule) throws Exception;
	ResponseResult save(HealthClassSchedule health_class_schedule, String center_id) throws Exception;
}
