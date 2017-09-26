package cn.segema.cloud.shrio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户角色关系
 * @author wangyong
 *
 */
@Table(name = "SYS_USER_ROLE")
@Entity
public class UserRole {
	@Id
	@Column(name = "USERROLEID",columnDefinition="varchar(100) COMMENT '用户角色关系ID'")
	private String userRoleId;

	@OneToOne
	@JoinColumn(name = "USERID",columnDefinition="varchar(100) COMMENT '用户ID'")
	private User user;

	@OneToOne
	@JoinColumn(name = "ROLEID",columnDefinition="varchar(100) COMMENT '角色ID'")
	private Role role;

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
