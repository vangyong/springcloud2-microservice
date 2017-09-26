package cn.segema.cloud.system.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员
 * @author wangyong
 *
 */
@Table(name = "SYS_PERSONAL")
@Entity
public class Personal {
	@Id
	@Column(name = "PERSONALID")
	private String personalId;
	
	@Column(name = "PERSONALNAME")
	private String personalName;
	
	@Column(name = "MOBILENUMBER")
	private String mobileNumber;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "BORNADDRESSID")
	private String bornAddressId;
	
	@Column(name = "BORNTIME")
	private LocalDateTime bornTime;
	
	@Column(name = "WEIGHT")
	private BigDecimal weight;
	
	@Column(name = "HEIGHT")
	private BigDecimal height;
	
	@Column(name = "BLOODTYPE")
	private BigDecimal bloodType;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "HOMEADDRESSID")
	private String homeAddressId;
	
	@Column(name = "GROUPID")
	private String groupId;
	
	@Column(name = "NATION")
	private String nation;
	
	@Column(name = "IDENTITYNUMBER")
	private String identityNumber;
	
	@Column(name = "CREATETIME")
	private LocalDateTime createTime;


	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBornAddressId() {
		return bornAddressId;
	}

	public void setBornAddressId(String bornAddressId) {
		this.bornAddressId = bornAddressId;
	}

	public LocalDateTime getBornTime() {
		return bornTime;
	}

	public void setBornTime(LocalDateTime bornTime) {
		this.bornTime = bornTime;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getBloodType() {
		return bloodType;
	}

	public void setBloodType(BigDecimal bloodType) {
		this.bloodType = bloodType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeAddressId() {
		return homeAddressId;
	}

	public void setHomeAddressId(String homeAddressId) {
		this.homeAddressId = homeAddressId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
