package cn.segema.cloud.performance.domain;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "REP_RESPONSIBILITY")
@Entity
public class Responsibility {
	@Id
	@Column(name="RESPONSIBILITY_ID")
	private String responsibilityId;
	
	@Column(name="RESPONSIBILITY_NAME")
	private String responsibilityName;
	
	@Column(name="ORGANIZATION_ID")
	private String organizationId;
	
	@Column(name="responsibility_year")
	private Integer responsibilityYear;
	
	@Column(name="total_score")
	private BigDecimal totalScore;
	
	@Column(name="remarks")
	private String remarks;

	public String getResponsibilityId() {
		return responsibilityId;
	}

	public void setResponsibilityId(String responsibilityId) {
		this.responsibilityId = responsibilityId;
	}

	public String getResponsibilityName() {
		return responsibilityName;
	}

	public void setResponsibilityName(String responsibilityName) {
		this.responsibilityName = responsibilityName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getResponsibilityYear() {
		return responsibilityYear;
	}

	public void setResponsibilityYear(Integer responsibilityYear) {
		this.responsibilityYear = responsibilityYear;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

}
