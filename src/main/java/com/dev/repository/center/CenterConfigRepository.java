package com.dev.repository.center;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.model.center.CenterConfig;

public interface CenterConfigRepository extends JpaRepository<CenterConfig, String> {
	
	/**
	 * 센터에 소속된 센터 운영방침 가져오기
	 * @param center_id
	 * 아래 query 수정해야됨
	 * @return
	 */
	@Query("select c from CenterConfig c where c.center_id = ?1 ")
	Optional<CenterConfig> getCenterCenterConfig(String center_id);

}
