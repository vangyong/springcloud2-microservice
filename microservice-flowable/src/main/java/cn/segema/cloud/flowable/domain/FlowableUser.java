package cn.segema.cloud.flowable.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "FLOWABLE_USER")
@Entity
public class FlowableUser {
	@Id
	@Column(name = "USERID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
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


}
