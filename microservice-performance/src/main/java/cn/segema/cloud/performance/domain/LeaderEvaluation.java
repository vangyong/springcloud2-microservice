package cn.segema.cloud.performance.domain;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PER_LEADER_EVALUATION")
@Entity
public class LeaderEvaluation {
	@Id
	@Column(name="EVALUATION_ID")
	private String evaluationId;
	
	@Column(name="EVALUATION_NAME")
	private String evaluationName;
	
	@Column(name="ORGANIZATION_ID")
	private String organizationId;
	
	@Column(name="EVALUATION_YEAR")
	private Integer evaluation_year;
	
	@Column(name="TOTAL_SCORE")
	private BigDecimal totalScore;
	
	@Column(name="AVERAGE_SCORE")
	private String averageScore;

	public String getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(String evaluationId) {
		this.evaluationId = evaluationId;
	}

	public String getEvaluationName() {
		return evaluationName;
	}

	public void setEvaluationName(String evaluationName) {
		this.evaluationName = evaluationName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getEvaluation_year() {
		return evaluation_year;
	}

	public void setEvaluation_year(Integer evaluation_year) {
		this.evaluation_year = evaluation_year;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	public String getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(String averageScore) {
		this.averageScore = averageScore;
	}


}
