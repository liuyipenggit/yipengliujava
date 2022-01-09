package com.yipeng.liu.kafkawork.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * kafka自定义分区
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.kafkawork.partitioner
 * @date 2021/10/16 17:33
 * @Copyright 韵达快递
 */
public class MyPartitioner implements Partitioner {

    /**
     * 自定义计算数据需要落在的分区
     *
     * @param s
     * @param o
     * @param bytes
     * @param o1
     * @param bytes1
     * @param cluster
     * @return
     */
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }

}
