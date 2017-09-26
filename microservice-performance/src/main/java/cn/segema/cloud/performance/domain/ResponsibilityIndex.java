package cn.segema.cloud.performance.domain;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "REP_RESPONSIBILITY_INDEX")
@Entity
public class ResponsibilityIndex {
	@Id
	@Column(name="INDEX_ID")
	private String indexId;
	
	@Column(name="INDEX_NAME")
	private String indexName;
	
	@Column(name="INDEX_CODE")
	private String indexCode;
	
	@Column(name="RESPONSIBILITY_ID")
	private String responsibilityId;
	
	@Column(name="INDEX_TYPE")
	private String indexType;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CALCULATION")
	private String calculation;
	
	@Column(name="VARIABLE_DESCRIPTION")
	private String variableDescription;
	
	@Column(name="BUDGET_TARGET")
	private String budgetTarget;
	
	@Column(name="DATA_SOURCES")
	private String dataSources;
	
	@Column(name="SELF_FILL")
	private String selfFill;
	
	@Column(name="WEIGHTS")
	private String weights;
	
	@Column(name="ACTUAL_COMPLATE")
	private String actualComplate;
	
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

	public String getResponsibilityId() {
		return responsibilityId;
	}

	public void setResponsibilityId(String responsibilityId) {
		this.responsibilityId = responsibilityId;
	}

	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCalculation() {
		return calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}

	public String getVariableDescription() {
		return variableDescription;
	}

	public void setVariableDescription(String variableDescription) {
		this.variableDescription = variableDescription;
	}

	public String getBudgetTarget() {
		return budgetTarget;
	}

	public void setBudgetTarget(String budgetTarget) {
		this.budgetTarget = budgetTarget;
	}

	public String getDataSources() {
		return dataSources;
	}

	public void setDataSources(String dataSources) {
		this.dataSources = dataSources;
	}

	public String getSelfFill() {
		return selfFill;
	}

	public void setSelfFill(String selfFill) {
		this.selfFill = selfFill;
	}

	public String getWeights() {
		return weights;
	}

	public void setWeights(String weights) {
		this.weights = weights;
	}

	public String getActualComplate() {
		return actualComplate;
	}

	public void setActualComplate(String actualComplate) {
		this.actualComplate = actualComplate;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}
