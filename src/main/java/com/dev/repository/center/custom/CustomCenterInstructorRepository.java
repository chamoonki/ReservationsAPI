package com.dev.repository.center.custom;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dev.dto.RegisterInstructorDTO;
import com.dev.dto.SettingInstructorDTO;

/**
 * CenterInstructor Rpository에서 사용할 DSL의 인터페이스
 *
 */
public interface CustomCenterInstructorRepository {
	
	List<SettingInstructorDTO> getSettingInstructor(String center_id) throws Exception;
	
	@Transactional
	int updateInstructor(RegisterInstructorDTO registerInstructor) throws Exception;
}
