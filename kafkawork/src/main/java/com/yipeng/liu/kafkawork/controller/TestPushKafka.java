package com.yipeng.liu.kafkawork.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.kafkawork.controller
 * @date 2021/7/12 18:03
 * @Copyright 韵达快递
 */
public class TestPushKafka {


    KafkaProducer<String, String> producer;

    public final static String TOPIC = "ordercenter.valet.order.topic";

    private TestPushKafka() {
        Properties props = new Properties();
        //xxx服务器ip
        props.put("bootstrap.servers", "10.172.32.18:1012,10.172.32.19:1012,10.172.32.20:1012");
        //所有follower都响应了才认为消息提交成功，即"committed"
        props.put("acks", "all");
        //retries = MAX 无限重试，直到你意识到出现了问题:)
        props.put("retries", 0);
        //producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
        //batch.size当批量的数据大小达到设定值后，就会立即发送，不顾下面的linger.ms
        props.put("batch.size", 16384);
        //延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
        props.put("linger.ms", 1);
        //producer可以用来缓存数据的内存大小。
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    public void produce() {
        try {
            producer.send(new ProducerRecord<>(TOPIC, "{\"orderList\":[{\"freight\":\"20.00\",\"goodsList\":[{\"name\":\"鞋子\",\"number\":\"1.0\",\"remark\":\"\"}],\"mailNo\":\"3120541789074\",\"orderCode\":\"2007121353258020712\",\"orderId\":2007121353258020712,\"orderType\":\"topay\",\"packageWd\":\"台州市内包  \",\"payType\":\"cashpay\",\"receiveInfo\":{\"address\":\"浙江省,台州市,温岭市泽国镇双峰村双峰一区192号\",\"city\":\"浙江省,台州市,温岭市\",\"mobile\":\"13566483065\",\"name\":\"lyp\"},\"remark\":\"\",\"sendInfo\":{\"address\":\"天丰市场韵达快递\",\"city\":\"云南省，临沧市，云县\",\"mobile\":\"15758692718\",\"name\":\"李忠萍\"},\"senderBranch\":\"677971\",\"status\":\"got\",\"submitTime\":1626069205000,\"threeSegmentCode\":\"398,D025-00,C2\",\"weight\":\"1.0\",\"ywyBm\":\"1126\",\"ywyGs\":\"677971\",\"ywyMobile\":\"13354982620\",\"ywyName\":\"夏荣\",\"ywyPhone\":\"13354982620\"}],\"processTime\":1626091883551,\"processor\":\"ywy_app\",\"requestType\":\"applyOrderCollected\"}"));
//            producer.send(new ProducerRecord<>(TOPIC,
//                    "{\"freight\":\"12.00\",\"goodsList\":[{\"name\":\"鞋子\",\"number\":\"1.0\",\"remark\":\"\"}],\"mailNo\":\"3120541789074\",\"orderCode\":\"2007121353258020712\",\"orderId\":2007121353258020712,\"orderType\":\"topay\",\"packageWd\":\"台州市内包  \",\"payType\":\"cashpay\",\"receiveInfo\":{\"address\":\"浙江省,台州市,温岭市泽国镇双峰村双峰一区192号\",\"city\":\"浙江省,台州市,温岭市\",\"mobile\":\"13566483065\",\"name\":\"秀秀公主\"},\"remark\":\"\",\"sendInfo\":{\"address\":\"天丰市场韵达快递\",\"city\":\"云南省，临沧市，云县\",\"mobile\":\"15758692718\",\"name\":\"李忠萍\"},\"senderBranch\":\"677971\",\"status\":\"got\",\"submitTime\":1626069205000,\"threeSegmentCode\":\"398,D025-00,C2\",\"weight\":\"1.0\",\"ywyBm\":\"1126\",\"ywyGs\":\"677971\",\"ywyMobile\":\"13354982620\",\"ywyName\":\"夏荣\",\"ywyPhone\":\"13354982620\"}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }

    public static void main(String[] args) {
        TestPushKafka testPushKafka = new TestPushKafka();
        testPushKafka.produce();
    }

}
