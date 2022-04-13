package com.dev.repository.lesson.custom;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.dev.dto.ScheduleClassDTO;
import com.dev.dto.SearchGridDTO;
import com.dev.dto.SettingInstructorDTO;
import com.dev.model.lesson.HealthClassSchedule;

/**
 * Schedule 관련 수업에 대한 Custom Interface 선언
 * 
 * <pre>
 * com.dev.repository.lesson.custom
 * CustomHealthClassScheduleRepository.java
 * </pre>
 *
 * @author  : moonki.cha
 * @Date   : 2019. 12. 5.
 * @Version :
 */
public interface CustomHealthClassScheduleRepository {
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 해당 월에 맞춰 schedule 정보를 가져온다.
	 * 2. 처리내용: Start Date & End Date에 맞게 해당 Schedule 정보를 가져온다.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 11. 26.
	 * @Version : 
	 * @Method Name: getSchedule
	 * @param StartDate
	 * @param endDate
	 * @return
	 */
	List<ScheduleClassDTO> getSchedule(Date StartDate, Date endDate, String cetner_id) throws ParseException;
}
