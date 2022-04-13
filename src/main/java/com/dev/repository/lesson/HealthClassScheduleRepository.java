package com.dev.repository.lesson;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.dto.SearchGridDTO;
import com.dev.model.lesson.HealthClassSchedule;
import com.dev.model.user.User;
import com.dev.repository.lesson.custom.CustomHealthClassScheduleRepository;

public interface HealthClassScheduleRepository extends JpaRepository<HealthClassSchedule, String>, CustomHealthClassScheduleRepository {
 
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
	//@Query("SELECT h FROM HealthClassSchedule h WHERE ((DATE(h.class_start_date) BETWEEN ?1 AND ?2) OR (DATE(h.class_start_date) <= ?1 AND DATE(h.class_end_date) >= ?1)) AND h.center_id = ?3")
	//Iterable<HealthClassSchedule> getSchedule(Date StartDate, Date endDate, String cetner_id);
	
}
