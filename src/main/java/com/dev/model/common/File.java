package com.dev.model.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class File implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "file_id", columnDefinition = "CHAR(32)")
	private String id;
	private String original_name;
	private String display_name;
	private String file_size;
	private String file_path;
	private String file_type;
	private String file_ext;
	private String reg_id;		//등록자
	private Date reg_dd;		//등록일
	private String mod_id;		//수정자
	private Date mod_dd;		//수정일
	
}
