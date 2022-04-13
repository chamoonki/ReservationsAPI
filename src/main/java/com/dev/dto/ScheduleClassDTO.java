package com.dev.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Schedule Grid 관련 찾기 모델
 * 
 * <pre>
 * com.dev.dto
 * SearchScheduleDTO.java
 * </pre>
 *
 * @author  : moonki.cha
 * @Date   : 2019. 11. 26.
 * @Version :
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScheduleClassDTO {
	// Schedule 또는 날짜를 설정 해야 하는 부분
	private String id;				// Schedule ID
    private String title;			// 수업 Name
	private Date endDateTime;		// 수업 종료 날짜 시간
	private Date startDateTime;	// 수업 시작 날짜 시간
	private String duration;		// 수업당 소요 시간
	private Integer interval;		// 몇주 마다 생성 할지의 여부
	private String class_week;		// 매주 몇일 마다 생성 할지의 여부
}
