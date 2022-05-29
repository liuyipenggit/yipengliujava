package com.yipeng.liu.springwork.beanFactory;

import org.springframework.context.ApplicationEvent;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanFactory
 * @date 2022/4/24 23:35
 * @Copyright 韵达快递
 */
public class UserRegisteredEvent extends ApplicationEvent {

    public UserRegisteredEvent(Object source) {
        super(source);
    }

}
