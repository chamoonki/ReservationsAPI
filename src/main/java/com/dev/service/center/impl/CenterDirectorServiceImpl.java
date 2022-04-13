package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.CenterDirector;
import com.dev.repository.center.CenterDirectorRepository;
import com.dev.service.center.form.CenterDirectorService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.security.SecurityUtil;

@Service
public class CenterDirectorServiceImpl implements CenterDirectorService {

    @Autowired
    private CenterDirectorRepository centerDirectorRepository;
    
    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    
    /**
     * 센터 원장 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CenterDirector> center_directors = new ArrayList<>();
			centerDirectorRepository.findAll().forEach(e -> center_directors.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_directors);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 원장 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_director_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterDirector CenterDirector = centerDirectorRepository.findById(center_director_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterDirector", "center_director_id", center_director_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterDirector);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 원장 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_director_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerDirectorRepository.deleteById(center_director_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_director_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 원장 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_director_id, CenterDirector center_director) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterDirector update_center_director = centerDirectorRepository.findById(center_director_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterDirector", "center_director_id", center_director_id));
			
			update_center_director.setBirthday(center_director.getBirthday());
			update_center_director.setEmail(center_director.getEmail());
			update_center_director.setPassword(center_director.getPassword());
			update_center_director.setMod_dd(new Date());
			update_center_director.setMod_id(center_director.getMod_id());
			update_center_director.setName(center_director.getName());
			update_center_director.setPhone(center_director.getPhone());
			update_center_director.setSex(center_director.getSex());
			
			centerDirectorRepository.save(update_center_director);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_director_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 원장 추가
    * @return
    */
	@Override
	public ResponseResult save(CenterDirector center_director) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			center_director.setPassword(encoder.encode(center_director.getPassword()));
			centerDirectorRepository.save(center_director);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_director);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
