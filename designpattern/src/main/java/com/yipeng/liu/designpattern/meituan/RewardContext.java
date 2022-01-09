package com.yipeng.liu.designpattern.meituan;

import com.yipeng.liu.designpattern.meituan.strategy.RewardStrategy;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan
 * @date 2022/1/5 19:59
 * @Copyright 韵达快递
 */
public class RewardContext {

    private RewardStrategy strategy;

    public RewardContext(RewardStrategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(long userId) {

        int rewardMoney = strategy.reward(userId);

        strategy.insertRewardAndSettlement(userId, rewardMoney);
//        insertRewardAndSettlement(userId, rewardMoney) {
//            insertReward(userId, rewardMoney);
//            settlement(userId);
//        }
    }

}
