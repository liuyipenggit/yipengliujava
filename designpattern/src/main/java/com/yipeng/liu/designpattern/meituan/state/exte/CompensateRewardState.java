package com.yipeng.liu.designpattern.meituan.state.exte;

import com.yipeng.liu.designpattern.meituan.RewardStateContext;
import com.yipeng.liu.designpattern.meituan.module.Request;
import com.yipeng.liu.designpattern.meituan.state.RewardState;

/**
 * 待补偿状态
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.state.exte
 * @date 2022/1/7 10:17
 * @Copyright 韵达快递
 */
public class CompensateRewardState extends RewardState {

    @Override
    public void doReward(RewardStateContext context, Request request) {
        //返奖失败，需要对用户进行返奖补偿
        compensateReward(context, request);
    }

    void compensateReward(RewardStateContext context, Request request){}
}
