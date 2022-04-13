package com.dev.service.center.form;

import com.dev.model.center.CenterPayment;
import com.dev.utils.response.ResponseResult;

public interface CenterPaymentService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_payment_id) throws Exception;
	ResponseResult deleteById(String center_payment_id) throws Exception;
	ResponseResult updateById(String center_payment_id, CenterPayment center_payment) throws Exception;
	ResponseResult save(CenterPayment center_payment) throws Exception;

}
