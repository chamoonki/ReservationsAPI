package com.dev.repository.lesson.custom;

import org.springframework.transaction.annotation.Transactional;

import com.dev.model.lesson.HealthClassType;

/**
 * HealthClassType Rpository에서 사용할 DSL의 인터페이스
 * @author k170750
 *
 */
public interface CustomHealthClassTypeRepository {
	
	@Transactional
	int updateById(HealthClassType health_class_type);
}
