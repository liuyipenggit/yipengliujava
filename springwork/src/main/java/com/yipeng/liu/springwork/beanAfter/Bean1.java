package com.yipeng.liu.springwork.beanAfter;

import com.yipeng.liu.springwork.beanFactory.Component1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanAfter
 * @date 2022/5/4 20:50
 * @Copyright 韵达快递
 */
public class Bean1 {

    public static final Logger log = LoggerFactory.getLogger(Component1.class);

    private Bean2 bean2;

    @Autowired
    public void setBean2(Bean2 bean2) {
        log.info("@Autowired生效：{}", bean2);
        this.bean2 = bean2;
    }

    private Bean3 bean3;

    @Autowired
    public void setBean3(Bean3 bean3) {
        log.info("@Resource生效：{}", bean2);
        this.bean3 = bean3;
    }

    private String home;

    @Autowired
    public void setHome(@Value("${JAVA_HOME}") String home) {
        log.info("@Value生效：{}", home);
        this.home = home;
    }

    @PostConstruct
    public void init() {
        log.info("@PostConstruct生效");
    }

    @PreDestroy
    public void destroy() {
        log.info("@PreDestroy生效");
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "bean2=" + bean2 +
                ", bean3=" + bean3 +
                ", home='" + home + '\'' +
                '}';
    }


}
