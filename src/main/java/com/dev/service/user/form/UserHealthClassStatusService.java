package com.dev.service.user.form;

import com.dev.model.user.UserHealthClassStatus;
import com.dev.utils.response.ResponseResult;

public interface UserHealthClassStatusService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String user_health_class_status_id) throws Exception;
	ResponseResult deleteById(String user_health_class_status_id) throws Exception;
	ResponseResult updateById(String user_health_class_status_id, UserHealthClassStatus user_health_class_status) throws Exception;
	ResponseResult save(UserHealthClassStatus user_health_class_status) throws Exception;

}
