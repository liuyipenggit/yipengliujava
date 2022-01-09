package com.yipeng.liu.designpattern.statepattern;

import com.yipeng.liu.designpattern.statepattern.exte.ConcreteStateA;

/**
 * 定义client执行
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.statepattern
 * @date 2022/1/6 18:01
 * @Copyright 韵达快递
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        context.handle1();
        context.handle2();
    }

}
