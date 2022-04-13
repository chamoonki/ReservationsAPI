package com.dev.repository.center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.model.center.CenterOrganization;

public interface CenterOrganizationRepository extends JpaRepository<CenterOrganization, String> {

	/**
	 * 센터 조직체계 목록 전체 가져오기
	 * @param center_id
	 * 아래 query 수정해야됨
	 * @return
	 */
	@Query("select o from CenterOrganization o where o.center_id = ?1 order by o.oraganization_level asc")
	Iterable<CenterOrganization> getCenterCenterOrganization(String center_id);

}
