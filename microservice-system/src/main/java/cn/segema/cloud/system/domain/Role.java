package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("角色")
@Data
@Table(name = "sys_role")
@Entity
public class Role {
	@ApiModelProperty(value="角色id")
	@Id
	@Column(name = "role_id")
	private String roleId;
	
	@ApiModelProperty(value="角色名称")
	@Column(name = "role_name")
	private String roleName;
	
	@ApiModelProperty(value="角色编码")
	@Column(name = "role_code")
	private String roleCode;
	
	@ApiModelProperty(value="描述")
	@Column(name = "description")
	private String description;
	
	@ApiModelProperty(value="上锁状态(1:已锁,2:未锁)")
	@Column(name = "locked")
	private Integer locked;
	
	@ApiModelProperty(value="删除标示(1:已删除,2:未删除)")
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	@ApiModelProperty(value="创建时间")
	@Column(name = "create_time")
	private BigInteger createTime;
	
    @ApiModelProperty(value="租户id")
    @Column(name = "tenant_id")
    private String tenantId;

}
