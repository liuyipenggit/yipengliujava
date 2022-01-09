package com.yipeng.liu.testwork.exception;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.testwork.exception
 * @date 2021/9/6 0:24
 * @Copyright 韵达快递
 */
public class ThrowsExceptionTest {

    public static void main(String[] args) {
        try {
            exception();
        } catch (Exception e) {
            System.out.println(2);
            e.printStackTrace();
        }finally {
            System.out.println("finally执行内容！");
        }
    }

    private static void exception() throws Exception{
        try {
            int a=1/0;
        } catch (NullPointerException e) {
            System.out.println(11111111);
            e.printStackTrace();
        }
    }

}
