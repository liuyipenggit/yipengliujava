package com.yipeng.liu.springwork.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Bean的生命周期
 * 核心：实例化 --> 填充属性  --> 初始化 --> 销毁
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.bean
 * @date 2022/5/3 11:42
 * @Copyright 韵达快递
 */
@SpringBootApplication
public class BeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BeanApplication.class);
        context.close();
    }

}
