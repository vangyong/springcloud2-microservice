package cn.segema.cloud.activiti.test.vo;

public class UserPersonalVO {

	private String userId;

	private String userName;

	private String nickName;
	
	private String personalId;
	
	private String personalName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
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

	public UserPersonalVO(String userId, String userName, String nickName, String personalId, String personalName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.personalId = personalId;
		this.personalName = personalName;
	}

	
}
