package com.yipeng.liu.designpattern.meituan;

import com.yipeng.liu.designpattern.meituan.module.Request;
import com.yipeng.liu.designpattern.meituan.state.RewardState;

/**
 * 返奖状态执行的上下文
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.demo02
 * @date 2022/1/7 10:08
 * @Copyright 韵达快递
 */
public class RewardStateContext {

    private RewardState rewardState;

    public void setRewardState(RewardState currentState) {this.rewardState = currentState;}

    public RewardState getRewardState() {return rewardState;}

    public void echo(RewardStateContext context, Request request) {
        rewardState.doReward(context, request);
    }

}
