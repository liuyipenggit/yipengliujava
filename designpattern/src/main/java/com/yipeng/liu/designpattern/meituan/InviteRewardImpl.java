package com.yipeng.liu.designpattern.meituan;

import com.yipeng.liu.designpattern.meituan.factory.exte.FactorRewardStrategyFactory;
import com.yipeng.liu.designpattern.meituan.module.Invitee;
import com.yipeng.liu.designpattern.meituan.module.UserTypeEnum;
import com.yipeng.liu.designpattern.meituan.strategy.exte.NewUserRewardStrategyA;
import com.yipeng.liu.designpattern.meituan.strategy.exte.OldUserRewardStrategyA;

/**
 * 工厂模式和策略模式结合
 * <p>
 * 工厂方法模式帮助我们直接产生一个具体的策略对象，策略模式帮助我们保证这些策略对象可以自由地切换而不需要改动其他逻辑，从而达到解耦的目的。
 * 通过这两个模式的组合，当我们系统需要增加一种返奖策略时，只需要实现RewardStrategy接口即可，无需考虑其他的改动。
 * 当我们需要改变策略时，只要修改策略的类名即可。不仅增强了系统的可扩展性，避免了大量的条件判断，而且从真正意义上达到了高内聚、低耦合的目的
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan
 * @date 2022/1/5 20:09
 * @Copyright 韵达快递
 */
public class InviteRewardImpl {

    /**
     * 返奖主流程
     *
     * @param userId
     */
    public void sendReward(long userId) {
        //创建工厂
        FactorRewardStrategyFactory strategyFactory = new FactorRewardStrategyFactory();
        //根据用户id查询用户信息
        Invitee invitee = getInviteeByUserId(userId);
        if (invitee.getUserType() == UserTypeEnum.NEW_USER.getCode()) {
            //新用户返奖策略
            NewUserRewardStrategyA newUserBasicReward = (NewUserRewardStrategyA) strategyFactory.createStrategy(NewUserRewardStrategyA.class);
            RewardContext rewardContext = new RewardContext(newUserBasicReward);
            //执行返奖策略
            rewardContext.doStrategy(userId);
        }
        if (invitee.getUserType() == UserTypeEnum.OLD_USER.getCode()) {
            //老用户返奖策略...
            OldUserRewardStrategyA oldUserReward = (OldUserRewardStrategyA) strategyFactory.createStrategy(OldUserRewardStrategyA.class);
            RewardContext rewardContext = new RewardContext(oldUserReward);
            //执行返奖策略
            rewardContext.doStrategy(userId);
        }

    }

    /**
     * 用于校验用户是新用户or老用户
     *
     * @param userId
     * @return
     */
    Invitee getInviteeByUserId(long userId) {
        return new Invitee();
    }

}
