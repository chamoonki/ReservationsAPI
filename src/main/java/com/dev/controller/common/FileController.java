package com.dev.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.common.File;
import com.dev.service.common.form.FileService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("file")
public class FileController {

	@Autowired
	private FileService fileService;
	
	/**
    * 파일 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllFile(HttpServletRequest request) throws Exception{
		ResponseResult result = fileService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 파일 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{file_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getFile(HttpServletRequest request,
			@PathVariable("file_id") String file_id) throws Exception{
		ResponseResult result = fileService.findById(file_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 파일 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{file_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteFile(HttpServletRequest request,
			@PathVariable("file_id") String file_id) throws Exception{
		ResponseResult result = fileService.deleteById(file_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 파일 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{file_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateFile(HttpServletRequest request,
			@PathVariable("file_id") String file_id,@RequestBody File file) throws Exception{
		ResponseResult result = fileService.updateById(file_id, file);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 파일 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> updateFile(HttpServletRequest request,
			@RequestBody File file) throws Exception{
		ResponseResult result = fileService.save(file);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
