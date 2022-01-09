package com.yipeng.liu.designpattern.statepattern;

import com.yipeng.liu.designpattern.statepattern.exte.ConcreteStateA;
import com.yipeng.liu.designpattern.statepattern.exte.ConcreteStateB;

/**
 * 定义一个上下文管理环境
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.statepattern
 * @date 2022/1/6 17:59
 * @Copyright 韵达快递
 */
public class Context {

    public final static ConcreteStateA contreteStateA = new ConcreteStateA();
    public final static ConcreteStateB contreteStateB = new ConcreteStateB();

    private State CurrentState;

    public State getCurrentState() {
        return CurrentState;
    }

    public void setCurrentState(State currentState) {
        this.CurrentState = currentState;
        this.CurrentState.setContext(this);
    }

    public void handle1() {
        this.CurrentState.handle1();
    }

    public void handle2() {
        this.CurrentState.handle2();
    }
}
