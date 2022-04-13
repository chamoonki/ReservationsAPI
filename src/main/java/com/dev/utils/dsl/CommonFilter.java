package com.dev.utils.dsl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * 
 * <pre>
 * com.dev.config.filter
 * CommonFilter.java
 * </pre>
 *
 * @author  : moonki.cha
 * @Date   : 2019. 11. 1.
 * @Version :
 */
@Configuration
public class CommonFilter {
	
	/**
	 * 
	 * <pre> 
	 * 1. 처리내용: List에 대한 Filter를 Map 형식으로 담아 준다. 
	 * </pre>
	 *
	 * @author  : moonki.cha
	 * @Date   : 2019. 11. 1.
	 * @Version : 
	 * @Method Name: listFilter
	 * @param request
	 * @return Map<String, Object><br>
	 * 		{<br>
	 * 			filter: (lastNamefilter),<br>
	 * 			order: (sortOrder),<br>
	 * 			field: (sortField),<br>
	 * 			offset: (pageNumber),<br>
	 * 			limit: (pageSize)<br>
	 * 		}
	 */
	public Map<String, Object> listFilter(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("filter", request.getParameter("lastNamefilter"));
		result.put("order", request.getParameter("sortOrder"));
		result.put("field", request.getParameter("sortField"));
		result.put("offset", request.getParameter("pageNumber"));
		result.put("limit", request.getParameter("pageSize"));
		
		return result; 
	}
	
	/**
     * 
     * <pre>
     * 1. 개요 : Integer Model Data를 Order를 선택 해 준다.
     * 2. 처리내용: 선택한 Model Data를 오름차순 & 내림차순으로 선택을 시켜 준다. 
     * 			   TODO: 이 또한 나중에 자동화를 시켜 줘야 한다.
     * </pre>
     *
     * @author  : moonki.cha
     * @Date   : 2019. 10. 25.
     * @Version : 
     * @Method Name: selectOrder
     * @param order
     * @param field
     * @return
     */
	public OrderSpecifier<Integer> selectOrder (String order, NumberPath<Integer> field) {
    	if("asc".equals(order))
    		return field.asc();
    	else
    		return field.desc();
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : Date Model Data를 Order를 선택 해 준다.
     * 2. 처리내용: 선택한 Model Data를 오름차순 & 내림차순으로 선택을 시켜 준다. 
     * 			   TODO: 이 또한 나중에 자동화를 시켜 줘야 한다.
     * </pre>
     *
     * @author  : moonki.cha
     * @Date   : 2019. 10. 25.
     * @Version : 
     * @Method Name: selectOrder
     * @param order
     * @param field
     * @return
     */
	public OrderSpecifier<Date> selectOrder (String order, DateTimePath<Date> field) {
    	if("asc".equals(order))
    		return field.asc();
    	else
    		return field.desc();
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : String Model Data를 Order를 선택 해 준다.
     * 2. 처리내용: 선택한 Model Data를 오름차순 & 내림차순으로 선택을 시켜 준다. 
     * 			   TODO: 이 또한 나중에 자동화를 시켜 줘야 한다. 
     * </pre>
     *
     * @author  : moonki.cha
     * @Date   : 2019. 10. 25.
     * @Version : 
     * @Method Name: selectOrder
     * @param order
     * @param field
     * @return
     */
	public OrderSpecifier<String> selectOrder (String order, StringPath field) {
    	if("asc".equals(order))
    		return field.asc();
    	else
    		return field.desc();
    }
}
