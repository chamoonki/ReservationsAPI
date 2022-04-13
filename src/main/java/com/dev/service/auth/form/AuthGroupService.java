package com.dev.service.auth.form;

import com.dev.model.auth.AuthGroup;
import com.dev.utils.response.ResponseResult;

public interface AuthGroupService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String group_id) throws Exception;
	ResponseResult deleteById(String group_id) throws Exception;
	ResponseResult updateById(String group_id, AuthGroup authGroup) throws Exception;
	ResponseResult save(AuthGroup authGroup) throws Exception;
	

}
