package com.dev.service.common.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.common.File;
import com.dev.repository.common.FileRepository;
import com.dev.service.common.form.FileService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;
    
    /**
     * 공통코드 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<File> files = new ArrayList<>();
			fileRepository.findAll().forEach(e -> files.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), files);
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
	public ResponseResult findById(String file_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			File File = fileRepository.findById(file_id).orElseThrow(
					() -> new ResourceNotFoundException("File", "file_id", file_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), File);
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
	public ResponseResult deleteById(String file_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			fileRepository.deleteById(file_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), file_id);
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
	public ResponseResult updateById(String file_id, File file) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			File update_file = fileRepository.findById(file_id).orElseThrow(
					() -> new ResourceNotFoundException("File", "file_id", file_id));
			
			update_file.setDisplay_name(file.getDisplay_name());
			update_file.setFile_ext(file.getFile_ext());
			update_file.setFile_path(file.getFile_path());
			update_file.setFile_size(file.getFile_size());
			update_file.setFile_type(file.getFile_type());
			update_file.setMod_dd(new Date());
			update_file.setMod_id(file.getMod_id());
			update_file.setOriginal_name(file.getOriginal_name());
			
			fileRepository.save(update_file);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), file_id);
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
	public ResponseResult save(File file) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			fileRepository.save(file);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), file);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
