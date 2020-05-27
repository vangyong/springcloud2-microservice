package cn.sgema.cloud.devtool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 代码生成配置
 */
@ConfigurationProperties(prefix = "devtool")
@Data
public class DevtoolProperties {

	//项目路径
	private String location;

	//开发者
	private String developer;

	//表的前缀
	private String prefix;

}
