package cn.segema.cloud.performance.domain;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "REP_RESPONSIBILITY_INDEX")
@Entity
public class LeaderEvaluationIndex {
	@Id
	@Column(name="INDEX_ID")
	private String indexId;
	
	@Column(name="INDEX_NAME")
	private String indexName;
	
	@Column(name="INDEX_CODE")
	private String indexCode;
	
	@Column(name="EVALUEATION_ID")
	private String evalueationId;
	
	@Column(name="SCORE")
	private BigDecimal score;

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

	public String getEvalueationId() {
		return evalueationId;
	}

	public void setEvalueationId(String evalueationId) {
		this.evalueationId = evalueationId;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}
