package com.dev.service.center.form;

import com.dev.model.center.CenterStatus;
import com.dev.utils.response.ResponseResult;

public interface CenterStatusService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_status_id) throws Exception;
	ResponseResult deleteById(String center_status_id) throws Exception;
	ResponseResult updateById(String center_status_id, CenterStatus center_status) throws Exception;
	ResponseResult save(CenterStatus center_status) throws Exception;

}
