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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 센터 강사 인사정보
 * <pre>
 * com.dev.model.center
 * CenterInstructor.java
 * </pre>
 *
 * @author  : KIM MIN KI
 * @Date   : 2019. 11. 12.
 * @Version :
 */
@Entity
@Table(name = "center_instructor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterInstructor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "center_instructor_id", columnDefinition = "CHAR(32)")
	private String id;							//센터 강사 인사정보 아이디 
	private String instructor_id;				//강사 아이디
	private String center_id;					//센터 아이디
	private String center_organization_id;		//조직체계 아이디
	private Integer instructor_status;			//강사 상태 (1 : 정상 , 2 : 퇴사, 3 : 정지)
	
	@Lob
	@Column( length = 100000 )
	private String instructor_desc;				//강사 비고
	private Date join_date;						//입사일
	private Date leave_date;					//퇴사일
	
	private String reg_id;		//생성자
	private Date reg_dd;		//생성일
	private String mod_id;		//수정자
	private Date mod_dd;		//수정일
	
}
