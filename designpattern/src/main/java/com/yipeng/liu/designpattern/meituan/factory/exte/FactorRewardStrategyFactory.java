package com.yipeng.liu.designpattern.meituan.factory.exte;

import com.yipeng.liu.designpattern.meituan.factory.StrategyFactory;
import com.yipeng.liu.designpattern.meituan.strategy.RewardStrategy;

/**
 * 具体工厂创建具体的策略
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.factory.exte
 * @date 2022/1/5 19:52
 * @Copyright 韵达快递
 */
public class FactorRewardStrategyFactory extends StrategyFactory {

    @Override
    public RewardStrategy createStrategy(Class c) {
        RewardStrategy product = null;
        try {
            product = (RewardStrategy) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
        }
        return product;
    }

}