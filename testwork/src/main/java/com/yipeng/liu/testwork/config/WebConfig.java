package com.yipeng.liu.testwork.config;

import com.yipeng.liu.testwork.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目启动时Filter
 *
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.testwork.config
 * @date 2021/8/20 11:24
 * @Copyright 韵达快递
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean casHttpServletRequestWrapperFilter(){
        FilterRegistrationBean authenticationFilter = new FilterRegistrationBean();
        authenticationFilter.setFilter(new MyFilter());
        authenticationFilter.setOrder(1);
        List<String> urlPatterns = new ArrayList<>();
        // 设置匹配的url
        urlPatterns.add("/*");
        authenticationFilter.setUrlPatterns(urlPatterns);
        return authenticationFilter;
    }

}
