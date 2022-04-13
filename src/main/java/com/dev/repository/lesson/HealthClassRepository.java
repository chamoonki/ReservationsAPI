package com.dev.repository.lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.model.lesson.HealthClass;
import com.dev.repository.lesson.custom.CustomHealthClassRepository;

public interface HealthClassRepository extends JpaRepository<HealthClass, String>, CustomHealthClassRepository {

	@Query("select h from HealthClass h where h.center_id = ?1")
	List<HealthClass> getCenterHealthClassList(String center_id);

}
