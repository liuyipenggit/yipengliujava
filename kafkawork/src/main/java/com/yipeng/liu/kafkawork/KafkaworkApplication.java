package com.yipeng.liu.kafkawork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class KafkaworkApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(KafkaworkApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    【KafkaWork】启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }

}
