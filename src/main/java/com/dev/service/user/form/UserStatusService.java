package com.dev.service.user.form;

import com.dev.model.user.UserStatus;
import com.dev.utils.response.ResponseResult;

public interface UserStatusService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String user_status_id) throws Exception;
	ResponseResult deleteById(String user_status_id) throws Exception;
	ResponseResult updateById(String user_status_id, UserStatus user_status) throws Exception;
	ResponseResult save(UserStatus user_status) throws Exception;

}
