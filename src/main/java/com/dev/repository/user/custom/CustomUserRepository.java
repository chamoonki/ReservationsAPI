package com.dev.repository.user.custom;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.dev.dto.SettingInstructorDTO;
import com.dev.dto.SearchGridDTO;
import com.dev.model.user.User;

/**
 * User Rpository에서 사용할 DSL의 인터페이스
 * @author k170750
 *
 */
public interface CustomUserRepository {
	
	/**
	 * 
	 * <pre>
	 *  1. 개요: 유료 회원 목록을 가져오는 Repository 
	 *  2. 처리내용: filter와 center ID를 가지고 유효 회원 목록을 조회해 온다.
	 * </pre>
	 *
	 * @author: moonki.cha
	 * @date : 2019. 10. 29.
	 * @version: 
	 * @method name: getChargedUser
	 * @param center_id
	 * @param filter
	 * @return
	 */
	List<SettingInstructorDTO> getChargedUser(String center_id, SearchGridDTO search) throws ParseException;
	
	/**
	 * 
	 * <pre>
	 *  1. 개요: 만기 회원 목록을 가져오는 Repository 
	 *  2. 처리내용: filter와 center ID를 가지고 만기 회원 목록을 조회해 온다.
	 * </pre>
	 *
	 * @author: moonki.cha
	 * @date : 2019. 10. 29.
	 * @version: 
	 * @method name: getExpiredUser
	 * @param center_id
	 * @param filter
	 * @return
	 */
	List<SettingInstructorDTO> getExpiredUser(String center_id, SearchGridDTO search) throws ParseException;
}
