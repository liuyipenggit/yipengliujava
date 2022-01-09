package com.yipeng.liu.designpattern.meituan.state.exte;

import com.yipeng.liu.designpattern.meituan.RewardStateContext;
import com.yipeng.liu.designpattern.meituan.module.Request;
import com.yipeng.liu.designpattern.meituan.state.RewardState;

/**
 * 待校验状态
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.state.exte
 * @date 2022/1/7 10:11
 * @Copyright 韵达快递
 */
public class OrderCheckState extends RewardState {

    @Override
    public void doReward(RewardStateContext context, Request request) {
        //对进来的订单进行校验，判断是否用券，是否满足优惠条件等等
        orderCheck(context, request);
    }

    void orderCheck(RewardStateContext context, Request request) {
    }
}
