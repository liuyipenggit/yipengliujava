package com.yipeng.liu.designpattern.meituan.state;

import com.yipeng.liu.designpattern.meituan.RewardStateContext;
import com.yipeng.liu.designpattern.meituan.module.Request;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.state
 * @date 2022/1/7 10:07
 * @Copyright 韵达快递
 */
public abstract class RewardState {

    public abstract void doReward(RewardStateContext context, Request request);

}
