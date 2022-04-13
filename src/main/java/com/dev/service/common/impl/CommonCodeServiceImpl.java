package com.dev.service.common.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.common.CommonCode;
import com.dev.repository.common.CommonCodeRepository;
import com.dev.service.common.form.CommonCodeService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class CommonCodeServiceImpl implements CommonCodeService {

    @Autowired
    private CommonCodeRepository commonCodeRepository;
    
    /**
     * 공통코드 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CommonCode> common_codes = new ArrayList<>();
			commonCodeRepository.findAll().forEach(e -> common_codes.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), common_codes);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 공통코드 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String code_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CommonCode common_code = commonCodeRepository.findById(code_id).orElseThrow(
					() -> new ResourceNotFoundException("CommonCode", "code_id", code_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), common_code);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 공통코드 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String code_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			commonCodeRepository.deleteById(code_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), code_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 공통코드 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String code_id, CommonCode common_code) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CommonCode update_common_code = commonCodeRepository.findById(code_id).orElseThrow(
					() -> new ResourceNotFoundException("CommonCode", "code_id", code_id));
			
			update_common_code.setCode_diff(common_code.getCode_diff());
			update_common_code.setCode_level(common_code.getCode_level());
			update_common_code.setCode_name(common_code.getCode_name());
			update_common_code.setCode_order(common_code.getCode_order());
			update_common_code.setDef_val(common_code.getDef_val());
			update_common_code.setRemarks(common_code.getRemarks());
			update_common_code.setMod_dd(new Date());
			update_common_code.setMod_id(common_code.getMod_id());
	
			commonCodeRepository.save(update_common_code);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), code_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 공통코드 추가
    * @return
    */
	@Override
	public ResponseResult save(CommonCode common_code) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			commonCodeRepository.save(common_code);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), common_code);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
