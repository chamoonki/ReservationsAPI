package com.dev.service.center.form;

import com.dev.model.center.CenterDirector;
import com.dev.utils.response.ResponseResult;

public interface CenterDirectorService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_director_id) throws Exception;
	ResponseResult deleteById(String center_director_id) throws Exception;
	ResponseResult updateById(String center_director_id, CenterDirector center_director) throws Exception;
	ResponseResult save(CenterDirector center_director) throws Exception;

}
