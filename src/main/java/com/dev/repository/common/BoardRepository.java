package com.dev.repository.common;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.model.common.Board;

public interface BoardRepository extends JpaRepository<Board, String> {

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용: 
	 * </pre>
	 *
	 * @author  : KIM MIN KI
	 * @Date   : 2019. 10. 30.
	 * @Version : 
	 * @Method Name: getCenterBoard
	 * @param center_id
	 * @return
	 */
	@Query("select b from Board b where b.center_id = ?1")
	Optional<Board> getCenterBoard(String center_id);

}
