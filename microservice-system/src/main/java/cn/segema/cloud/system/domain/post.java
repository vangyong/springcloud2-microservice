package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 岗位
 * @author wangyong
 *
 */
@Table(name = "sys_post")
@Entity
@Data
public class post {
	@Id
	@Column(name = "post_id")
	private String postId;
	
	@Column(name = "postname")
	private String postName;
	
	@Column(name = "post_code")
	private String postCode;
	
	@ApiModelProperty(value = "创建时间")
	@Column(name = "create_time")
	private BigInteger createTime;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	@ApiModelProperty(value = "租户id")
	@Column(name = "tenant_id")
	private String tenantId;

	
}
