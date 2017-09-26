package cn.segema.cloud.performance.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PER_CUSTOMER_SURVEY")
@Entity
public class CustomerSurvey {
	@Id
	@Column(name="SURVEY_ID")
	private String surveyId;
	
	@Column(name="SURVEY_NAME")
	private String surveyName;
	
	@Column(name="ORGANIZATION_ID")
	private String organizationId;
	
	@Column(name="survey_year")
	private Integer survey_year;
	
	@Column(name="TOTAL_SCORE")
	private String totalScore;
	
	@Column(name="AVERAGE_SCORE")
	private String averageScore;
	
	@Column(name="SUGGEST")
	private String suggest;

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getSurvey_year() {
		return survey_year;
	}

	public void setSurvey_year(Integer survey_year) {
		this.survey_year = survey_year;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(String averageScore) {
		this.averageScore = averageScore;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

}
