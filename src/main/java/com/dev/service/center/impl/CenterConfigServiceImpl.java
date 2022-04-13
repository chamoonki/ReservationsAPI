package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.CenterConfig;
import com.dev.repository.center.CenterConfigRepository;
import com.dev.service.center.form.CenterConfigService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class CenterConfigServiceImpl implements CenterConfigService {

    @Autowired
    private CenterConfigRepository centerConfigRepository;
    
    /**
     * 센터 운영 방침 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CenterConfig> center_configs = new ArrayList<>();
			centerConfigRepository.findAll().forEach(e -> center_configs.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_configs);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 운영 방침 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_config_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterConfig CenterConfig = centerConfigRepository.findById(center_config_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterConfig", "center_config_id", center_config_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterConfig);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 운영 방침 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_config_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerConfigRepository.deleteById(center_config_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_config_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 운영 방침 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_config_id, CenterConfig center_config) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterConfig update_center_config = centerConfigRepository.findById(center_config_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterConfig", "center_config_id", center_config_id));
			
			update_center_config.setAttendance_public_unit(center_config.getAttendance_public_unit());
			update_center_config.setAttendance_public_time(center_config.getAttendance_public_time());
			update_center_config.setCenter_id(center_config.getCenter_id());
			update_center_config.setMod_dd(new Date());
			update_center_config.setMod_id(center_config.getMod_id());
			update_center_config.setReserv_cancle_unit(center_config.getReserv_cancle_unit());
			update_center_config.setReserv_cancle_time(center_config.getReserv_cancle_time());
			update_center_config.setReserv_modify_unit(center_config.getReserv_modify_unit());
			update_center_config.setReserv_modify_time(center_config.getReserv_modify_time());
			update_center_config.setReserv_public_unit(center_config.getReserv_public_unit());
			update_center_config.setReserv_public_time(center_config.getReserv_public_time());
			update_center_config.setTardy_after_unit(center_config.getTardy_after_unit());
			update_center_config.setTardy_after_time(center_config.getTardy_after_time());
			update_center_config.setMaturity_time(center_config.getMaturity_time());
			update_center_config.setMaturity_unit(center_config.getMaturity_unit());
			
			centerConfigRepository.save(update_center_config);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_config_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 운영 방침 추가
    * @return
    */
	@Override
	public ResponseResult save(CenterConfig center_config) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerConfigRepository.save(center_config);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_config);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
	 * 센터별 센터 운영 방침 조회
	 */
	@Override
	public ResponseResult getCenterCenterConfig(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterConfig CenterConfig = centerConfigRepository.getCenterCenterConfig(center_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterConfig", "center_id", center_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterConfig);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

}
