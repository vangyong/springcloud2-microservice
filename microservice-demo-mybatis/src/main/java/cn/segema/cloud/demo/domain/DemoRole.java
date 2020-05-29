package cn.segema.cloud.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("角色")
@Data
@Table(name = "sys_role")
@Entity
public class DemoRole {
	@Id
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_code")
	private String roleCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "locked")
	private Integer locked;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;

	

}
