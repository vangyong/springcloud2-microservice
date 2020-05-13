package cn.segema.cloud.flowable.config;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;

public class FlowableConfig implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {
	@Override
	public void configure(SpringProcessEngineConfiguration engineConfiguration) {
		engineConfiguration.setActivityFontName("宋体");
		engineConfiguration.setLabelFontName("宋体");
		engineConfiguration.setAnnotationFontName("宋体");
	}
}
