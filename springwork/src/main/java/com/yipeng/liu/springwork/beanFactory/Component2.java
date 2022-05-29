package com.yipeng.liu.springwork.beanFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanFactory
 * @date 2022/4/19 23:25
 * @Copyright 韵达快递
 */
@Component
public class Component2 {

    public static final Logger log = LoggerFactory.getLogger(Component2.class);

    @EventListener
    public void a(UserRegisteredEvent userRegisteredEvent) {
        log.info("EventListener监听事件：", userRegisteredEvent);
        log.info("发送短信逻辑");
    }

}
