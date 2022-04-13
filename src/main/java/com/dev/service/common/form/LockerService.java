package com.dev.service.common.form;

import com.dev.model.common.Locker;
import com.dev.utils.response.ResponseResult;

public interface LockerService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String locker_id) throws Exception;
	ResponseResult deleteById(String locker_id) throws Exception;
	ResponseResult updateById(String locker_id, Locker locker) throws Exception;
	ResponseResult save(Locker locker) throws Exception;

}
