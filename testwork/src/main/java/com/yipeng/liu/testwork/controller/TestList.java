package com.yipeng.liu.testwork.controller;

import java.util.ArrayList;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.testwork.controller
 * @date 2021/7/30 10:04
 * @Copyright 韵达快递
 */
public class TestList {

    public static void main(String[] args) {
//        forEachReturn();
    }

    /**
     * arraylist循环中
     * forEach:跳出当前循环用return
     * for:break结束当前循环；continue跳过当前循环进入下个循环
     *
     * @return: void
     * @authror: lyp
     * @date 2021/7/30 10:05
     * @version 1.0
     */
    private static void forEachReturn() {
        ArrayList<Integer> list = paseIntegerList();
        list.forEach(o -> {
            if (o == 2 || o == 5) {
                return;
            }
            System.out.println(o);
        });
    }

    private static ArrayList<Integer> paseIntegerList() {
        ArrayList<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
        }};
        return list;
    }

}
