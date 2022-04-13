package com.dev.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.RegisterUserDTO;
import com.dev.dto.SearchGridDTO;
import com.dev.model.user.User;
import com.dev.service.user.form.UserService;
import com.dev.utils.dsl.CommonFilter;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
    * 사용자 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllUser(HttpServletRequest request) throws Exception{
		ResponseResult result = userService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 사용자가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{user_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getUser(HttpServletRequest request,
			@PathVariable("user_id") String user_id) throws Exception{
		ResponseResult result = userService.findById(user_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 사용자 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{user_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteUser(HttpServletRequest request,
			@PathVariable("user_id") String user_id) throws Exception{
		ResponseResult result = userService.deleteById(user_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{user_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateUser(HttpServletRequest request,
			@PathVariable("user_id") String user_id,@RequestBody User user) throws Exception{
		ResponseResult result = userService.updateById(user_id, user);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 사용자 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveUser(HttpServletRequest request,
			@RequestBody User user) throws Exception{
		ResponseResult result = userService.save(user);
		return ResponseUtil.getResponseEntity(result, request);
	}	
	
	/**
	 * 
	 * <pre>
	 *  1. 개요: 유효 회원 목록 가져오기 
	 *  2. 처리내용: 현재 수강 중 & 결제를 한 회원 목록을 가져온다.
	 * </pre>
	 *
	 * @author: moonki.cha
	 * @date : 2019. 10. 29.
	 * @version: 
	 * @method name: getChargedUser
	 * @param request
	 * @param center_id
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin("*")
	@GetMapping(value = "/charged/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getChargedUser(HttpServletRequest request,
			@PathVariable("center_id") String center_id, 
			@ModelAttribute("search") SearchGridDTO search) throws Exception{
		
		ResponseResult result = userService.getChargedUser(center_id, search);
		return ResponseUtil.getResponseEntity(result, request);
	}
		
	/**
	 * 
	 * <pre>
	 *  1. 개요: 만기 회원 목록 가져오기
	 *  2. 처리내용: 결제 만기 되어 가는 회원의 목록을 가져 온다.
	 * </pre>
	 *
	 * @author: moonki.cha
	 * @date : 2019. 10. 29.
	 * @version: 
	 * @method name: getExpiredUser
	 * @param request
	 * @param center_id
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin("*")
	@GetMapping(value = "/expired/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getExpiredUser(HttpServletRequest request,
			@PathVariable("center_id") String center_id, 
			@ModelAttribute("search") SearchGridDTO search) throws Exception{
		
		ResponseResult result = userService.getExpiredUser(center_id, search);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터에 소속된 강사 목록 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/instructor/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getInstructorUser(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = userService.getInstructorUser(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 회원 등록
    * @return
    */
	@CrossOrigin("*")
	@PostMapping(value = "/registerUser")
	public ResponseEntity<ResponseResult> registerUser(HttpServletRequest request,
			@RequestBody RegisterUserDTO registerUser) throws Exception{
		ResponseResult result = userService.registerUser(registerUser);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
