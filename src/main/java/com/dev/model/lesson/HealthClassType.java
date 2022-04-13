package com.dev.model.lesson;

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
 * 수업 카테고리 테이블
 *
 */
@Entity
@Table(name = "health_class_Type")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthClassType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "health_class_Type_id", columnDefinition = "CHAR(32)")
    private String id;					//아이디
	
	@Nationalized
	private String name;				//이름
	private String center_id;			//센터 아이디
	private Boolean is_use;				//수업 사용여부
	
	@Lob
	@Column( length = 100000 )
	private String remarks;				//비고
	
	private String reg_id;			
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
