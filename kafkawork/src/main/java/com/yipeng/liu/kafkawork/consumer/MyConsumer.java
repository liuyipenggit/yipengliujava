package com.yipeng.liu.kafkawork.consumer;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.kafkawork.consumer
 * @date 2021/10/24 16:56
 * @Copyright 韵达快递
 */
public class MyConsumer {

    public static void main(String[] args) {

//        1.创建消费者配置信息
        Properties properties = new Properties();

//        2.给配置赋值

//        连接的集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.172.32.18:1012,10.172.32.19:1012,10.172.32.20:1012");
//        开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        开启提交的延时
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");

//        key,value反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");

//        消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "yipeng");

//        重置消费者组的offset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "elarliest");

//        创建消费者组
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

//        订阅主题
        consumer.subscribe(Arrays.asList("promotioncenter_event_after"));

//        获取数据
        ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

//        解析并打印consumer
        while (true) {
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() + "--" + consumerRecord.value());
            }
        }
    }

}
