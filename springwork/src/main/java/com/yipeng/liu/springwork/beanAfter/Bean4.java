package com.yipeng.liu.springwork.beanAfter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanAfter
 * @date 2022/5/4 22:06
 * @Copyright 韵达快递
 */
@ConfigurationProperties(prefix = "java")
public class Bean4 {

    private String home;

    private String version;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
