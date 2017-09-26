package cn.segema.cloud.shrio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 角色资源关系
 * 
 * @author wangyong
 *
 */
@Table(name = "SYS_ROLE_RESOURCE")
@Entity
public class RoleResource {
	@Id
	@Column(name = "ROLERESOURCEID", columnDefinition = "varchar(100) COMMENT '角色资源关系ID'")
	private String roleResourceId;

	@OneToOne
	@JoinColumn(name = "ROLEID", columnDefinition = "varchar(100) COMMENT '角色ID'")
	private Role role;

	@OneToOne
	@JoinColumn(name = "RESOURCEID", columnDefinition = "varchar(100) COMMENT ' 资源ID'")
	private Resource resource;

	public String getRoleResourceId() {
		return roleResourceId;
	}

	public void setRoleResourceId(String roleResourceId) {
		this.roleResourceId = roleResourceId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
