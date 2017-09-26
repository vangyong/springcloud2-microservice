package cn.segema.cloud.shrio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色
 * @author wangyong
 *
 */
@Table(name = "SYS_ROLE")
@Entity
public class Role {
	@Id
	@Column(name = "ROLEID")
	private String roleId;
	
	@Column(name = "ROLENAME")
	private String roleName;
	
	@Column(name = "ROLECODE")
	private String roleCode;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "LOCKED")
	private Integer locked;
	
	@Column(name = "DELETESTATUS")
	private Integer deletestatus;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

}
