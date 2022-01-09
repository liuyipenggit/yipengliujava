package com.yipeng.liu.designpattern.meituan.strategy.exte;

import com.yipeng.liu.designpattern.meituan.strategy.RewardStrategy;

/**
 * 新用户返奖具体策略A
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.strategy.impl
 * @date 2022/1/5 19:45
 * @Copyright 韵达快递
 */
public class NewUserRewardStrategyA extends RewardStrategy {

    @Override
    public int reward(long userId) {
        //具体的计算逻辑...
        return 1;
    }

}
