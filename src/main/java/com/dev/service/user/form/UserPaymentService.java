package com.dev.service.user.form;

import com.dev.model.user.UserPayment;
import com.dev.utils.response.ResponseResult;

public interface UserPaymentService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String user_payment_id) throws Exception;
	ResponseResult deleteById(String user_payment_id) throws Exception;
	ResponseResult updateById(String user_payment_id, UserPayment user_payment) throws Exception;
	ResponseResult save(UserPayment user_payment) throws Exception;

}
