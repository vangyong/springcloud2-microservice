package cn.segema.cloud.mail.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplySimple {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String comtent;
	private Integer state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComtent() {
		return comtent;
	}
	public void setComtent(String comtent) {
		this.comtent = comtent;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
