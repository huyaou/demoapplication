package com.example.cn.demoapplication.config;

import com.example.cn.demoapplication.common.DemoInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private DemoInteceptor demoInteceptor;

    /**
     * 添加自定义的拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInteceptor)
                .addPathPatterns("/demo/**", "/cache/**")
                .excludePathPatterns("/jpaController/**");
    }
}
