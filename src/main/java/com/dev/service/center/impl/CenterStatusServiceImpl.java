package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.CenterStatus;
import com.dev.repository.center.CenterStatusRepository;
import com.dev.service.center.form.CenterStatusService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class CenterStatusServiceImpl implements CenterStatusService {

    @Autowired
    private CenterStatusRepository CenterStatusRepository;
    
    /**
     * 센터 상태 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CenterStatus> center_statuss = new ArrayList<>();
			CenterStatusRepository.findAll().forEach(e -> center_statuss.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_statuss);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 상태 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_status_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterStatus CenterStatus = CenterStatusRepository.findById(center_status_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterStatus", "center_status_id", center_status_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterStatus);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 상태 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_status_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterStatusRepository.deleteById(center_status_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_status_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 상태 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_status_id, CenterStatus center_status) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterStatus update_center_status = CenterStatusRepository.findById(center_status_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterStatus", "center_status_id", center_status_id));
			
			update_center_status.setCenter_id(center_status.getCenter_id());
			update_center_status.setManagement_end_dd(center_status.getManagement_end_dd());
			update_center_status.setManagement_id(center_status.getManagement_id());
			update_center_status.setManagement_start_dd(center_status.getManagement_start_dd());
			update_center_status.setMod_dd(new Date());
			update_center_status.setMod_id(center_status.getMod_id());
			update_center_status.setStatus(center_status.getStatus());
			
			CenterStatusRepository.save(update_center_status);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_status_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 상태 추가
    * @return
    */
	@Override
	public ResponseResult save(CenterStatus center_status) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterStatusRepository.save(center_status);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_status);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
