package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("资源")
@Data
@Table(name = "sys_resource")
@Entity
public class Resource  {
	@Id
	@Column(name = "resource_id")
    private String resourceId;
	
	@Column(name = "resource_name")
    private String resourceName;
	
	@Column(name = "parent_id")
    private String parentId;
	
	@Column(name = "resource_code")
    private String resourceCode;
	
	@Column(name = "type")
    private String type;
	
	@Column(name = "resource_url")
    private String resourceUrl;
	
	@Column(name = "rank")
    private String rank;
	
	@Column(name = "icon")
    private String icon;
	
	@Column(name = "hide")
    private Integer hide;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "delete_status")
    private Integer deleteStatus;

  
}
