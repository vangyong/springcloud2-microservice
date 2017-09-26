package cn.segema.cloud.elasticsearch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "SYS_USER_PERSONAL")
@Entity
public class UserPersonal {
	@Id
	@Column(name = "USERPERSONALID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userPersonalId;

	@OneToOne
	@JoinColumn(name = "USERID")
	private User user;

	@OneToOne
	@JoinColumn(name = "PERSONALID")
	private Personal personal;

	public String getUserPersonalId() {
		return userPersonalId;
	}

	public void setUserPersonalId(String userPersonalId) {
		this.userPersonalId = userPersonalId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}
