package com.dev.service.common.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.common.Board;
import com.dev.repository.common.BoardRepository;
import com.dev.service.common.form.BoardService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;
    
    /**
     * 게시판 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<Board> boards = new ArrayList<>();
			boardRepository.findAll().forEach(e -> boards.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), boards);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 게시판 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String board_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Board board = boardRepository.findById(board_id).orElseThrow(
					() -> new ResourceNotFoundException("Board", "board_id", board_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), board);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 게시판 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String board_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			boardRepository.deleteById(board_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), board_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 게시판 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String board_id, Board board) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Board update_board = boardRepository.findById(board_id).orElseThrow(
					() -> new ResourceNotFoundException("Board", "board_id", board_id));
			
			update_board.setBoard_order(board.getBoard_order());
			update_board.setBoard_type(board.getBoard_type());
			update_board.setTitle(board.getTitle());
			update_board.setContent(board.getContent());
			update_board.setHit(board.getHit());
			update_board.setMod_id(board.getMod_id());
			update_board.setMod_dd(new Date());
			
			boardRepository.save(update_board);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), board_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 게시판 추가
    * @return
    */
	@Override
	public ResponseResult save(Board board) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			boardRepository.save(board);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), board);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
	 * 센터별 게시판 목록 가져오기
	 */
	@Override
	public ResponseResult getCenterBoard(String center_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			Board board = boardRepository.getCenterBoard(center_id).orElseThrow(
					() -> new ResourceNotFoundException("Board", "center_id", center_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), board);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

}
