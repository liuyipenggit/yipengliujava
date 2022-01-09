package com.yipeng.liu.designpattern.meituan.strategy;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan
 * @date 2022/1/5 18:45
 * @Copyright 韵达快递
 */
public abstract class RewardStrategy {

    public abstract int reward(long userId);

    /**
     * 更新用户信息以及结算
     *
     * @param userId
     * @param reward
     */
    public void insertRewardAndSettlement(long userId, int reward) {
    }

}
