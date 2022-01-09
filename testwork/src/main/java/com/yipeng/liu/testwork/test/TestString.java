package com.yipeng.liu.testwork.test;

/**
 * 测试string字符串是否包含某个子串
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.testwork.test
 * @date 2021/9/23 13:37
 * @Copyright 韵达快递
 */
public class TestString {

    public static void main(String[] args) {
//        "city_express".equalsIgnoreCase(bmOrderData.getOrderType())
        boolean b1 = ",  COLD-CHAIN ,okkk,".contains("cold-chain");
        boolean b2 = ",  COLD-CHAIN ,okkk,".contains("COLD-CHAIN");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1||b2);
    }

}
