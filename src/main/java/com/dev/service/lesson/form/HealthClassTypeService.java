package com.dev.service.lesson.form;

import com.dev.model.lesson.HealthClassType;
import com.dev.utils.response.ResponseResult;

public interface HealthClassTypeService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String health_class_type_id) throws Exception;
	ResponseResult deleteById(String health_class_type_id) throws Exception;
	ResponseResult updateById(String health_class_type_id, HealthClassType health_class_type) throws Exception;
	ResponseResult save(HealthClassType health_class_type) throws Exception;
	ResponseResult getCenterHealthClassType(String center_id) throws Exception;

}
