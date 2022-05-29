package com.yipeng.liu.springwork.bean;

import com.yipeng.liu.springwork.beanFactory.Component1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean生命周期
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.bean
 * @date 2022/5/3 23:39
 * @Copyright 韵达快递
 */
@Component
public class LifeCycleBean {

    public static final Logger log = LoggerFactory.getLogger(Component1.class);

    public LifeCycleBean() {
        log.info("无参构造");
    }

    @Autowired
    public void autowire(@Value("${JAVA_HOME}") String home) {
        log.info("依赖注入：{}", home);
    }

    @PostConstruct
    public void init() {
        log.info("初始化");
    }

    /**
     * 销毁方法只在bean是单例情况下才会调用
     */
    @PreDestroy
    public void destroy() {
        log.info("销毁");
    }

}
