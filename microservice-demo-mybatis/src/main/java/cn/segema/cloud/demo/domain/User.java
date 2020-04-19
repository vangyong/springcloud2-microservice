package cn.segema.cloud.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 * @author wangyong
 *
 */
@Table(name = "SYS_USER")
@Entity
public class User {
	@Id
	@Column(name = "USERID")
	private String userId;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "NICKNAME")
	private String nickName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "MOBILENUMBER")
	private String mobileNumber;
	
	@Column(name = "CREDENTIALSSALT")
	private String credentialsSalt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCredentialsSalt() {
		return credentialsSalt;
	}

	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}

}
