package com.dev.service.lesson.form;

import com.dev.model.lesson.HealthClassReserv;
import com.dev.utils.response.ResponseResult;

public interface HealthClassReservService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String health_class_reserv_id) throws Exception;
	ResponseResult deleteById(String health_class_reserv_id) throws Exception;
	ResponseResult updateById(String health_class_reserv_id, HealthClassReserv health_class_reserv) throws Exception;
	ResponseResult save(HealthClassReserv health_class_reserv) throws Exception;

}
