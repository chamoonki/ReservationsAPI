package com.dev.service.common.form;

import com.dev.model.common.CommonCode;
import com.dev.utils.response.ResponseResult;

public interface CommonCodeService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String code_id) throws Exception;
	ResponseResult deleteById(String code_id) throws Exception;
	ResponseResult updateById(String code_id, CommonCode common_code) throws Exception;
	ResponseResult save(CommonCode common_code) throws Exception;

}
