package cn.segema.cloud.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 组织
 * @author wangyong
 *
 */
@Table(name = "SYS_ORGANIZATION")
@Entity
public class Organization {
	@Id
	@Column(name = "ORGANIZATIONID")
	private String orgnizationId;

	@Column(name = "ORGANIZATIONNAME")
	private String orgnizationName;

	@Column(name = "ORGANIZATIONCODE")
	private String orgnizationCode;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PARENTID")
	private String parentId;

	@Column(name = "TYPE")
	private Integer type;

	public String getOrgnizationId() {
		return orgnizationId;
	}

	public void setOrgnizationId(String orgnizationId) {
		this.orgnizationId = orgnizationId;
	}

	public String getOrgnizationName() {
		return orgnizationName;
	}

	public void setOrgnizationName(String orgnizationName) {
		this.orgnizationName = orgnizationName;
	}

	public String getOrgnizationCode() {
		return orgnizationCode;
	}

	public void setOrgnizationCode(String orgnizationCode) {
		this.orgnizationCode = orgnizationCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
