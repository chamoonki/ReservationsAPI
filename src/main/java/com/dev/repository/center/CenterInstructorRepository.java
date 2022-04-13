package com.dev.repository.center;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.center.CenterInstructor;
import com.dev.repository.center.custom.CustomCenterInstructorRepository;

public interface CenterInstructorRepository extends JpaRepository<CenterInstructor, String>, CustomCenterInstructorRepository{

}
