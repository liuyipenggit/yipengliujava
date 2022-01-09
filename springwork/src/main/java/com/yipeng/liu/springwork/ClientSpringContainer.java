package com.yipeng.liu.springwork;

import com.yipeng.liu.springwork.module.A;
import com.yipeng.liu.springwork.module.B;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring循环依赖debug启动类
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork
 * @date 2022/1/8 22:47
 * @Copyright 韵达快递
 */
public class ClientSpringContainer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("a", A.class);
        context.getBean("b", B.class);
    }

}
