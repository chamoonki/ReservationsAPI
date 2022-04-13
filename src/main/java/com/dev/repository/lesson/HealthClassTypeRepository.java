package com.dev.repository.lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.model.lesson.HealthClassType;
import com.dev.repository.lesson.custom.CustomHealthClassTypeRepository;

public interface HealthClassTypeRepository extends JpaRepository<HealthClassType, String>, CustomHealthClassTypeRepository {

	
	@Query("select h from HealthClassType h where h.center_id = ?1")
	List<HealthClassType> getCenterHealthClassType(String center_id);

}
