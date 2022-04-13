package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.CenterOrganization;
import com.dev.model.user.User;
import com.dev.repository.center.CenterOrganizationRepository;
import com.dev.service.center.form.CenterOrganizationService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class CenterOrganizationServiceImpl implements CenterOrganizationService {

    @Autowired
    private CenterOrganizationRepository centerOrganizationRepository;
    
    /**
     * 센터 조직체계 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CenterOrganization> center_organizations = new ArrayList<>();
			centerOrganizationRepository.findAll().forEach(e -> center_organizations.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_organizations);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 조직체계 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_organization_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterOrganization CenterOrganization = centerOrganizationRepository.findById(center_organization_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterOrganization", "center_organization_id", center_organization_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterOrganization);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 조직체계 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_organization_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerOrganizationRepository.deleteById(center_organization_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_organization_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 조직체계 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_organization_id, CenterOrganization center_organization) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterOrganization update_center_organization = centerOrganizationRepository.findById(center_organization_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterOrganization", "center_organization_id", center_organization_id));
			
			update_center_organization.setMod_dd(new Date());
			update_center_organization.setMod_id(center_organization.getMod_id());
			update_center_organization.setOraganization_desc(center_organization.getOraganization_desc());
			update_center_organization.setOraganization_level(center_organization.getOraganization_level());
			update_center_organization.setOraganization_title(center_organization.getOraganization_title());
			update_center_organization.setOrganization_diff(center_organization.getOrganization_diff());
			
			centerOrganizationRepository.save(update_center_organization);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_organization_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 조직체계 추가
    * @return
    */
	@Override
	public ResponseResult save(CenterOrganization center_organization) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerOrganizationRepository.save(center_organization);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_organization);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
	 * 센터 조직체계 목록 전체 가져오기
	 */
	@Override
	public ResponseResult getCenterCenterOrganization(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{			
			List<CenterOrganization> center_organizations = new ArrayList<>();
			centerOrganizationRepository.getCenterCenterOrganization(center_id).forEach(e -> center_organizations.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_organizations);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
