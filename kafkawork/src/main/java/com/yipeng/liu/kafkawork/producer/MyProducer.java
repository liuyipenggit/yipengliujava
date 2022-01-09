package com.yipeng.liu.kafkawork.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 生产者推送指定kafka
 *
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.kafkawork.controller
 * @date 2021/7/12 18:03
 * @Copyright 韵达快递
 */
public class MyProducer {


    KafkaProducer<String, String> producer;

    public final static String TOPIC = "promotioncenter_event_after";
//    public final static String TOPIC = "promotioncenter_reissue_coupon_topic";

    public static void main(String[] args) {
        MyProducer myProducer = new MyProducer();
        myProducer.produce();
    }

    public void produce() {
        try {
            producer.send(new ProducerRecord<>(TOPIC,"282490066462508517"));
//            producer.send(new ProducerRecord<>(TOPIC,
//                    "{\"id\": 36082860660377829, \"activityId\": 27100951773754301, \"userId\": \"139788704322220859\", \"mobilePhone\": \"13046578868\",\"startTime\": \"2021-04-18 23:10:29\", \"endTime\": \"2021-04-20 23:10:29\"}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }

    private MyProducer() {
        Properties props = new Properties();
        /**
         * 指定连接kafka服务器
         */
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.172.32.18:1012,10.172.32.19:1012,10.172.32.20:1012");
//        props.put("bootstrap.servers", "10.172.16.18:1013,10.172.16.20:1013,10.172.16.30:1013");

        /**
         * ACK应答级别：
         * acks = 0（低延迟）
         * producer 不等待broker 的ack，broker 一接收到还没有写入磁盘就已经返回，当broker故障时有可能丢失数据
         * acks = 1
         * producer等待broker的ack，partition的leader落盘成功后返回ack，如果在follower同步成功之前leader故障，那么将会丢失数据
         * acks = all
         * leader将等待follower都响应了才认为消息提交成功。如果在follower同步完成后，broker发送ack之前，leader发生故障，那么会造成数据重复
         */
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        /**
         * 重试次数
         * retries = MAX 无限重试，
         */
        props.put(ProducerConfig.RETRIES_CONFIG, 0);

        /**
         * producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
         * batch.size当批量的数据大小达到设定值后，就会立即发送，不顾下面的linger.ms
         */
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);

        /**
         * 延迟1ms发送，这项设置将通过增加小的延迟来完成
         * --即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
         */
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);

        /**
         * producer可以用来缓存数据的内存大小
         * 32M
         */
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

}
