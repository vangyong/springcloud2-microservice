package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户")
@Data
@Table(name = "sys_user")
@Entity
public class User {
	@ApiModelProperty(value = "用户id")
	@Id
	@Column(name = "user_id")
	private String userId;

	@ApiModelProperty(value = "用户名称")
	@Column(name = "user_name")
	private String userName;

	@ApiModelProperty(value = "昵称")
	@Column(name = "nick_name")
	private String nickName;

	@ApiModelProperty(value = "密码")
	@Column(name = "password")
	private String password;

	@ApiModelProperty(value = "手机号码")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@ApiModelProperty(value = "盐值")
	@Column(name = "credentials_salt")
	private String credentialsSalt;

	@ApiModelProperty(value = "性别(1:男,2:女,3:保密)")
	@Column(name = "gender")
	private Integer gender;

	@ApiModelProperty(value = "删除标示(1:已删除,2:未删除)")
	@Column(name = "delete_status")
	private Integer deleteStatus;

	@ApiModelProperty(value = "创建时间")
	@Column(name = "create_time")
	private BigInteger createTime;

	@ApiModelProperty(value = "租户id")
	@Column(name = "tenant_id")
	private String tenantId;

	@ApiModelProperty(value = "头像url")
	@Column(name = "avatar_url")
	private String avatarUrl;

}
