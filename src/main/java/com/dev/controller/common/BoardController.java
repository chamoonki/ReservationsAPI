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

import com.dev.model.common.Board;
import com.dev.service.common.form.BoardService;
import com.dev.utils.response.ResponseResult;
import com.dev.utils.response.ResponseUtil;


@CrossOrigin("*")
@RestController
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	/**
    * 게시판 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getAllBoard(HttpServletRequest request) throws Exception{
		ResponseResult result = boardService.findAll();
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 지정 아이디 게시판 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/{board_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getBoard(HttpServletRequest request,
			@PathVariable("board_id") String board_id) throws Exception{
		ResponseResult result = boardService.findById(board_id);
		return ResponseUtil.getResponseEntity(result, request);
	}

	/**
    * 게시판 삭제
    * @return
    */
	@CrossOrigin("*")
	@DeleteMapping(value = "/{board_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> deleteBoard(HttpServletRequest request,
			@PathVariable("board_id") String board_id) throws Exception{
		ResponseResult result = boardService.deleteById(board_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 게시판 수정
    * @return
    */
	@CrossOrigin("*")
	@PatchMapping(value = "/{board_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> updateBoard(HttpServletRequest request,
			@PathVariable("board_id") String board_id,@RequestBody Board board) throws Exception{
		ResponseResult result = boardService.updateById(board_id, board);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 게시판 추가
    * @return
    */
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<ResponseResult> saveBoard(HttpServletRequest request,
			@RequestBody Board board) throws Exception{
		ResponseResult result = boardService.save(board);
		return ResponseUtil.getResponseEntity(result, request);
	}
	
	/**
    * 센터별 게시판 목록 전체 가져오기
    * @return
    */
	@CrossOrigin("*")
	@GetMapping(value = "/center/{center_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseResult> getCenterBoard(HttpServletRequest request,
			@PathVariable("center_id") String center_id) throws Exception{
		ResponseResult result = boardService.getCenterBoard(center_id);
		return ResponseUtil.getResponseEntity(result, request);
	}
}
