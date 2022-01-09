package com.yipeng.liu.rediswork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class RedisworkApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(RedisworkApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    【redis】启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }

}
