package com.yipeng.liu.springwork.module;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.module
 * @date 2022/1/8 22:51
 * @Copyright 韵达快递
 */
public class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        System.out.println("B success");
        this.a = a;
    }

}
