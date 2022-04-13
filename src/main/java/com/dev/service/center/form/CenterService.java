package com.dev.service.center.form;

import com.dev.model.center.Center;
import com.dev.utils.response.ResponseResult;

public interface CenterService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_id) throws Exception;
	ResponseResult deleteById(String center_id) throws Exception;
	ResponseResult updateById(String center_id, Center center) throws Exception;
	ResponseResult save(Center center) throws Exception;

}
