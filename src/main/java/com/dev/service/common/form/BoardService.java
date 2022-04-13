package com.dev.service.common.form;

import com.dev.model.common.Board;
import com.dev.utils.response.ResponseResult;

public interface BoardService {

	ResponseResult findAll() throws Exception;
	ResponseResult findById(String board_id) throws Exception;
	ResponseResult deleteById(String board_id) throws Exception;
	ResponseResult updateById(String board_id, Board board) throws Exception;
	ResponseResult save(Board board) throws Exception;
	ResponseResult getCenterBoard(String center_id) throws Exception;

}
