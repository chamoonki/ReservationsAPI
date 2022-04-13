package com.dev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GRID 관련 찾기 모델
 * 모델명은 Search / Grid / Pagination 개발자의 취향에 따라 다름
 * VO 보단 read only 성격을 가지며 DB의 값을 가지고 정제하는것이 아니므로  DTO로 분류
 * <pre>
 * com.dev.dto
 * SearchGridDTO.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 11. 4.
 * @Version :
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchGridDTO {
	// 기본 테이블에서 사용 되는 Search
	private String filter;
	private String sortOrder;
	private String sortField;
	private Integer pageNumber;
	private Integer pageSize;	
}
