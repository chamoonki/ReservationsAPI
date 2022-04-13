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

@Entity
@Table(name = "center")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Center implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "center_id", columnDefinition = "CHAR(32)")
    private String id;				//센터 아이디
	private String director_id;		//원장 아이디
	
	@Nationalized
	private String name;			//센터 명
	private String imgae_id;		//센터 표지 이미지 아이디
	private String address;			//센터 주소
	private String tel;				//센터 연락처
	
	@Lob
	@Column( length = 100000 )
	private String remarks;			//센터 설명
	private String reg_id;
	private Date reg_dd;
	private String mod_id;
	private Date mod_dd;
	
}
