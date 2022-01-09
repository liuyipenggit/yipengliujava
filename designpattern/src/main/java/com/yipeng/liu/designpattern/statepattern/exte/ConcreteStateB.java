package com.yipeng.liu.designpattern.statepattern.exte;

import com.yipeng.liu.designpattern.statepattern.Context;
import com.yipeng.liu.designpattern.statepattern.State;

/**
 * 定义状态B
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.statepattern.impl
 * @date 2022/1/6 17:44
 * @Copyright 韵达快递
 */
public class ConcreteStateB extends State {

    @Override
    public void handle2() {
        //本状态下必须要处理的事情，...
    }

    @Override
    public void handle1() {
        //切换到状态A
        super.context.setCurrentState(Context.contreteStateA);
        //执行状态A的任务
        super.context.handle1();
    }

}
