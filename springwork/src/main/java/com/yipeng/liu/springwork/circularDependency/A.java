package com.yipeng.liu.springwork.circularDependency;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.module
 * @date 2022/1/8 22:50
 * @Copyright 韵达快递
 */
public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        System.out.println("A success");
        this.b = b;
    }

}
