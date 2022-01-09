package com.yipeng.liu.designpattern.statepattern;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.statepattern
 * @date 2022/1/6 17:40
 * @Copyright 韵达快递
 */
public abstract class State {

    public Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handle1();

    public abstract void handle2();

}
