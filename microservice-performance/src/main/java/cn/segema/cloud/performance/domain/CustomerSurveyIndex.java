package cn.segema.cloud.performance.domain;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "REP_RESPONSIBILITY_INDEX")
@Entity
public class CustomerSurveyIndex {
	@Id
	@Column(name="INDEX_ID")
	private String indexId;
	
	@Column(name="INDEX_NAME")
	private String indexName;
	
	@Column(name="INDEX_CODE")
	private String indexCode;
	
	@Column(name="SURVEY_ID")
	private String surveyId;
	
	@Column(name="SCORE")
	private BigDecimal score;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
