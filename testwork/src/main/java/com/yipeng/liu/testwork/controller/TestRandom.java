package com.yipeng.liu.testwork.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.testwork.controller
 * @date 2021/7/30 10:00
 * @Copyright 韵达快递
 */
public class TestRandom {
    public static void main(String[] args) {
//        random(3);
    }

    /**
     * 从list.size()中取出count个随机数
     *
     * @param count
     * @return: void
     * @authror: lyp
     * @date 2021/7/30 10:03
     * @version 1.0
     */
    private static void random(int count) {
        ArrayList<Integer> list = paseIntegerList();
        List<Integer> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            int index = ThreadLocalRandom.current().nextInt(list.size());
            result.add(list.get(index));
            list.remove(index);
        }
        System.out.println("中奖用户有" + result);
    }

    /**
     * 创建一个list塞入几个值
     *
     * @return: java.util.ArrayList<java.lang.Integer>
     * @authror: lyp
     * @date 2021/7/30 10:01
     * @version 1.0
     */
    private static ArrayList<Integer> paseIntegerList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        return list;
    }
}
