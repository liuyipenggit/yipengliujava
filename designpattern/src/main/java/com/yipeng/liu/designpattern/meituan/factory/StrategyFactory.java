package com.yipeng.liu.designpattern.meituan.factory;

import com.yipeng.liu.designpattern.meituan.strategy.RewardStrategy;

/**
 * 抽象工厂
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.factory
 * @date 2022/1/5 19:49
 * @Copyright 韵达快递
 */
public abstract class StrategyFactory<T> {

    public abstract RewardStrategy createStrategy(Class<T> c);

}
