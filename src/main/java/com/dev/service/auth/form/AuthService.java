package com.dev.service.auth.form;

import com.dev.model.auth.Auth;
import com.dev.utils.response.ResponseResult;

public interface AuthService {

	ResponseResult userLogin(Auth auth) throws Exception;

}
