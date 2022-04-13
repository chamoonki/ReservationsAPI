package com.dev.service.manager.form;

import com.dev.model.manager.Management;
import com.dev.utils.response.ResponseResult;

public interface ManagementService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String management_id) throws Exception;
	ResponseResult deleteById(String management_id) throws Exception;
	ResponseResult updateById(String management_id, Management management) throws Exception;
	ResponseResult save(Management management) throws Exception;

}
