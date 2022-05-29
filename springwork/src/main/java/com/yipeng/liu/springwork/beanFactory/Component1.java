package com.yipeng.liu.springwork.beanFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanFactory
 * @date 2022/4/19 23:25
 * @Copyright 韵达快递
 */
@Component
public class Component1 {

    public static final Logger log = LoggerFactory.getLogger(Component1.class);

    @Autowired
    private ApplicationEventPublisher context;

    /**
     * 用户注册后发送事件
     * 功能上实现：注册与发短信解耦
     */
    public void register() {
        log.info("用户注册");
        context.publishEvent(new UserRegisteredEvent(this));
    }

}
