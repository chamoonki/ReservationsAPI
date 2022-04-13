package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dto.RegisterInstructorDTO;
import com.dev.dto.SettingInstructorDTO;
import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.CenterInstructor;
import com.dev.model.user.User;
import com.dev.repository.center.CenterInstructorRepository;
import com.dev.repository.user.UserRepository;
import com.dev.service.center.form.CenterInstructorService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.security.SecurityUtil;

@Service
public class CenterInstructorServiceImpl implements CenterInstructorService {

    @Autowired
    private CenterInstructorRepository centerInstructorRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    private SecurityUtil security = new SecurityUtil();
    
    /**
     * 센터 강사 인사정보 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CenterInstructor> center_instructors = new ArrayList<>();
			centerInstructorRepository.findAll().forEach(e -> center_instructors.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_instructors);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 강사 인사정보 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_instructor_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterInstructor CenterInstructor = centerInstructorRepository.findById(center_instructor_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterInstructor", "center_instructor_id", center_instructor_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterInstructor);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 강사 인사정보 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_instructor_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerInstructorRepository.deleteById(center_instructor_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_instructor_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 강사 인사정보 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_instructor_id, CenterInstructor center_instructor) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterInstructor update_center_instructor = centerInstructorRepository.findById(center_instructor_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterInstructor", "center_instructor_id", center_instructor_id));
			
			update_center_instructor.setCenter_organization_id(center_instructor.getCenter_organization_id());
			update_center_instructor.setInstructor_desc(center_instructor.getInstructor_desc());
			update_center_instructor.setInstructor_status(center_instructor.getInstructor_status());
			update_center_instructor.setJoin_date(center_instructor.getJoin_date());
			update_center_instructor.setLeave_date(center_instructor.getLeave_date());
			update_center_instructor.setMod_dd(new Date());
			update_center_instructor.setMod_id(center_instructor.getMod_id());
			
			centerInstructorRepository.save(update_center_instructor);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_instructor_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 강사 인사정보 추가
    * @return
    */
	@Override
	public ResponseResult save(CenterInstructor center_instructor) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerInstructorRepository.save(center_instructor);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_instructor);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 강사 등록
    * @return
    */
	@Override
	public ResponseResult registerInstructor(RegisterInstructorDTO registerInstructor) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			//강사
			User user = new User(registerInstructor.getUser_id(),security.encryptAES256(registerInstructor.getPassword()),
					registerInstructor.getName(),registerInstructor.getPhone(), registerInstructor.getAddress(),
					registerInstructor.getSex(),registerInstructor.getBirthday(),registerInstructor.getEmail(),
					registerInstructor.getCenter_id(),registerInstructor.getUser_type(), registerInstructor.getReg_id(),
					new Date(),null,null);
			userRepository.save(user);
			
			//인사 정보
			CenterInstructor center_instructor = new CenterInstructor(null, registerInstructor.getInstructor_id(), 
					registerInstructor.getCenter_id(), registerInstructor.getCenter_organization_id(), registerInstructor.getInstructor_status(), 
					registerInstructor.getInstructor_desc(), registerInstructor.getJoin_date(), registerInstructor.getLeave_date(), 
					registerInstructor.getReg_id(), null, null, null);
			centerInstructorRepository.save(center_instructor);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		
		return result;
	}

	/**
	 * 강사 수정
	 */
	@Override
	public ResponseResult updateInstructor(RegisterInstructorDTO registerInstructor) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			
			//수정
			int update_result = centerInstructorRepository.updateInstructor(registerInstructor);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), update_result);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
	 * 세팅 - 강사 목록 가져오기
	 */
	@Override
	public ResponseResult getSettingInstructor(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<SettingInstructorDTO> list = new ArrayList<>();
			centerInstructorRepository.getSettingInstructor(center_id).forEach(e -> list.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), list);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	

}
