package com.dev.repository.lesson.custom;

import java.util.List;

import com.dev.dto.SettingHealthClassDTO;

/**
 * HealthClass Rpository에서 사용할 DSL의 인터페이스
 * @author k170750
 *
 */
public interface CustomHealthClassRepository {
	
	List<SettingHealthClassDTO> getSettingHealthClassList(String center_id);
}
