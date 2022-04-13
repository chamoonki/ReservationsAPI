package com.dev.controller.lesson;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.ScheduleClassDTO;
import com.dev.model.lesson.HealthClassSchedule;
import com.dev.service.lesson.form.HealthClassScheduleService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("healthClassSchedule")
public class HealthClassScheduleController {

	@Autowired
	private HealthClassScheduleService healthClassScheduleService;
	
	/**
    * 수업 일정 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllHealthClassSchedule(HttpServletRequest request) throws Exception{
		ResponseResult result = healthClassScheduleService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 수업 일정 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{health_class_schedule_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getHealthClassSchedule(HttpServletRequest request,
			@PathVariable("health_class_schedule_id") String health_class_schedule_id) throws Exception{
		ResponseResult result = healthClassScheduleService.findById(health_class_schedule_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 선택 한 달에 대한 Schedule 정보를 가져온다. 
	 * 2. 처리내용: start & end Date를 이용하여 해당 달에 대한 센터 별 Schedule 정보들을 가져온다,.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 11. 26.
	 * @Version : 
	 * @Method Name: getHealthClassSchedulebyCenter
	 * @param request
	 * @param center_id
	 * @param search
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin("*")
	@GetMapping(value = "/month/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getHealthClassSchedulebyCenter(HttpServletRequest request,
			@PathVariable("center_id") String center_id,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate
			) throws Exception{
		ResponseResult result = healthClassScheduleService.findBySchedule(startDate, endDate, center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 수업 일정 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{health_class_schedule_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteHealthClassSchedule(HttpServletRequest request,
			@PathVariable("health_class_schedule_id") String health_class_schedule_id) throws Exception{
		ResponseResult result = healthClassScheduleService.deleteById(health_class_schedule_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 일정 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{health_class_schedule_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateHealthClassSchedule(HttpServletRequest request,
			@PathVariable("health_class_schedule_id") String health_class_schedule_id,@RequestBody HealthClassSchedule health_class_schedule) throws Exception{
		ResponseResult result = healthClassScheduleService.updateById(health_class_schedule_id, health_class_schedule);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 수업 일정 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> actionHealthClassSchedule(HttpServletRequest request,
			@RequestBody HealthClassSchedule health_class_schedule) throws Exception{
		//ResponseResult result = healthClassScheduleService.save(health_class_schedule);
		ResponseResult result = new ResponseResult();
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 해당 Center에 대한 수업 스케쥴을 등록 시켜 준다.
	 * 2. 처리내용: url path로 center_id를 받아 센터 별 특정 수업에 대한 스케쥴을 넣어 준다.
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 11. 25.
	 * @Version : 
	 * @Method Name: insertHealthClassSchedule
	 * @param request
	 * @param center_id
	 * @param health_class_schedule
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin("*")
	@PutMapping(value="/{center_id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> insertHealthClassSchedule(HttpServletRequest request,
			@PathVariable("center_id") String center_id,
			@RequestBody HealthClassSchedule health_class_schedule) throws Exception{

		ResponseResult result = healthClassScheduleService.save(health_class_schedule, center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
