package cn.sgema.cloud.devtool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
	
	/**
     * 性能分析拦截器，不建议生产使用 用来观察 SQL 执行情况及执行时长, 默认dev,staging 环境开启
     * @author fxbin
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
     */
    @Bean
    @Profile({"dev", "staging"})
    public PerformanceInterceptor performanceInterceptor(){

        //启用性能分析插件, SQL是否格式化 默认false,此处开启
        return new PerformanceInterceptor().setFormat(true);
    }


    /**
     * 分页插件
     * @author fxbin
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
