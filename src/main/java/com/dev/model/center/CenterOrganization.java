package com.dev.model.center;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 센터 조직체계
 * <pre>
 * com.dev.model.center
 * CenterOrganization.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 11. 12.
 * @Version :
 */
@Entity
@Table(name = "center_organization")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterOrganization implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "center_organization_id", columnDefinition = "CHAR(32)")
	private String id;							//조직체계 아이디
	private String center_id;					//센터 아이디
	private String organization_diff;			//부서 상위 아이디 (차후 그룹매핑을 위해)
	
	@Nationalized
	private String oraganization_title;			//조직체계 제목
	
	@Lob
	@Column( length = 100000 )
	private String oraganization_desc;			//조직체계 비고
	private Integer oraganization_level;		//조직체계 레벨
	
	private String reg_id;		//생성자
	private Date reg_dd;		//생성일
	private String mod_id;		//수정자
	private Date mod_dd;		//수정일
	
}
