package com.yipeng.liu.designpattern.statepattern.exte;

import com.yipeng.liu.designpattern.statepattern.Context;
import com.yipeng.liu.designpattern.statepattern.State;

/**
 * 定义状态A
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.statepattern.impl
 * @date 2022/1/6 17:43
 * @Copyright 韵达快递
 */
public class ConcreteStateA extends State {

    @Override
    public void handle1() {
        //本状态下必须要处理的事情
    }

    @Override
    public void handle2() {
        //切换到状态B
        super.context.setCurrentState(Context.contreteStateB);
        //执行状态B的任务
        super.context.handle2();
    }

}
