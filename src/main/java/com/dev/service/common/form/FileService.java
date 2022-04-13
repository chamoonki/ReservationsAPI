package com.dev.service.common.form;

import com.dev.model.common.File;
import com.dev.utils.response.ResponseResult;

public interface FileService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String file_id) throws Exception;
	ResponseResult deleteById(String file_id) throws Exception;
	ResponseResult updateById(String file_id, File file) throws Exception;
	ResponseResult save(File file) throws Exception;

}
