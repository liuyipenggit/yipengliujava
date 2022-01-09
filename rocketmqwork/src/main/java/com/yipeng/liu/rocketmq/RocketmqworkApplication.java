package com.yipeng.liu.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class RocketmqworkApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(RocketmqworkApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    【RocketMQWork】启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }

}
