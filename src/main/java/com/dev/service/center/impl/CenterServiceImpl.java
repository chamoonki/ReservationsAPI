package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.Center;
import com.dev.repository.center.CenterRepository;
import com.dev.service.center.form.CenterService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterRepository centerRepository;
    
    /**
     * 센터 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<Center> Centers = new ArrayList<>();
			centerRepository.findAll().forEach(e -> Centers.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), Centers);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Center Center = centerRepository.findById(center_id).orElseThrow(
					() -> new ResourceNotFoundException("Center", "center_id", center_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), Center);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerRepository.deleteById(center_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_id, Center center) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Center update_center = centerRepository.findById(center_id).orElseThrow(
					() -> new ResourceNotFoundException("Center", "center_id", center_id));
			
			update_center.setAddress(center.getAddress());
			update_center.setDirector_id(center.getDirector_id());
			update_center.setImgae_id(center.getImgae_id());
			update_center.setName(center.getName());
			update_center.setRemarks(center.getRemarks());
			update_center.setTel(center.getTel());
			update_center.setMod_id(center.getMod_id());
			update_center.setMod_dd(new Date());
			
			centerRepository.save(update_center);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 추가
    * @return
    */
	@Override
	public ResponseResult save(Center center) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerRepository.save(center);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
