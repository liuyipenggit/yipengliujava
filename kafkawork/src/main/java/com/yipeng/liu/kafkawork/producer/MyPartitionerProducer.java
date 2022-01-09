package com.yipeng.liu.kafkawork.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 生产者使用自定义分区策略发送消息
 * 分区策略见com.yipeng.liu.kafkawork.partitioner.MyPartitioner
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.kafkawork.producer
 * @date 2021/10/16 17:57
 * @Copyright 韵达快递
 */
public class MyPartitionerProducer {

    public static void main(String[] args) {

//        1.创建Kafka生产者配置信息
        Properties props = new Properties();

//        2.指定连接kafka服务器
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.172.32.18:1012,10.172.32.19:1012,10.172.32.20:1012");

//        3.ACK应答级别
        props.put(ProducerConfig.ACKS_CONFIG, "all");

//        4.重试次数
        props.put(ProducerConfig.RETRIES_CONFIG, 0);

//        5.producer将试图批处理消息记录
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);

//        6.延迟1ms发送
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);

//        7.producer可以用来缓存数据的内存大小
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);

//        8.key value序列化类
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

//        9.添加自定义分区器
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.yipeng.liu.kafkawork.partitioner.MyPartitioner");

//        10.创建生产者对象
        KafkaProducer kafkaProducer = new KafkaProducer<>(props);

//        11.发送数据
//        添加get方法表示同步发送，get获取的是线程对象
        try {
            kafkaProducer.send(new ProducerRecord("promotioncenter_event_after","yipeng", "111111111")).get();
        } catch (Exception e) {
            e.getMessage();
        }

//        11.关闭资源
        kafkaProducer.close();

    }
}
