package com.dev.service.lesson.form;

import com.dev.model.lesson.HealthClass;
import com.dev.utils.response.ResponseResult;

public interface HealthClassService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String health_status_id) throws Exception;
	ResponseResult deleteById(String health_status_id) throws Exception;
	ResponseResult updateById(String health_status_id, HealthClass health_class) throws Exception;
	ResponseResult save(HealthClass health_class) throws Exception;
	ResponseResult getCenterHealthClassList(String center_id) throws Exception;
	ResponseResult getSettingHealthClassList(String center_id) throws Exception;

}
