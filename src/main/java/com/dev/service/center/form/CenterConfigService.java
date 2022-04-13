package com.dev.service.center.form;

import com.dev.model.center.CenterConfig;
import com.dev.utils.response.ResponseResult;

public interface CenterConfigService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_config_id) throws Exception;
	ResponseResult deleteById(String center_config_id) throws Exception;
	ResponseResult updateById(String center_config_id, CenterConfig center_config) throws Exception;
	ResponseResult save(CenterConfig center_config) throws Exception;
	ResponseResult getCenterCenterConfig(String center_id) throws Exception;

}
