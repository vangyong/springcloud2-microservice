package cn.sgema.cloud.devtool.domain;

import lombok.Data;

@Data
public class Generator {

	private String projectLocation;

	private String tablePrefix;

	private String packageName;

	private String tableName;

	private String entityName;

	private String module;

	private String developer;

	private Boolean onlyGenerateEntity;
}
