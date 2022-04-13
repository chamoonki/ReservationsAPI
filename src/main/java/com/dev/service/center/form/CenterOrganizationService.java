package com.dev.service.center.form;

import com.dev.model.center.CenterOrganization;
import com.dev.utils.response.ResponseResult;

public interface CenterOrganizationService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String center_organization_id) throws Exception;
	ResponseResult deleteById(String center_organization_id) throws Exception;
	ResponseResult updateById(String center_organization_id, CenterOrganization center_organization) throws Exception;
	ResponseResult save(CenterOrganization center_organization) throws Exception;
	ResponseResult getCenterCenterOrganization(String center_id) throws Exception;
}
