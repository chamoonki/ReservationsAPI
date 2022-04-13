package com.dev.service.center.form;

import com.dev.dto.RegisterInstructorDTO;
import com.dev.model.center.CenterInstructor;
import com.dev.utils.response.ResponseResult;

public interface CenterInstructorService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_instructor_id) throws Exception;
	ResponseResult deleteById(String center_instructor_id) throws Exception;
	ResponseResult updateById(String center_instructor_id, CenterInstructor center_instructor) throws Exception;
	ResponseResult save(CenterInstructor center_instructor) throws Exception;
	ResponseResult registerInstructor(RegisterInstructorDTO registerInstructor) throws Exception;
	ResponseResult updateInstructor(RegisterInstructorDTO registerInstructor) throws Exception;
	ResponseResult getSettingInstructor(String center_id) throws Exception;
	
}
