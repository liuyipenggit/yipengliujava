package com.yipeng.liu.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier字面意思时可循环（Cyclic）使用的屏障（Barrier）
 * 它要做的事情是让一组线程到达一个屏障（也也已叫做同步点）时阻塞，直到最后一个线程到达屏障时，
 * 屏障才会开门，所有被屏障拦截的线程才会继续干活，线程进入屏障通过CyclicBarrier的await()方法
 * 一句话概括：集齐七颗龙珠召唤神龙
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.cyclicbarrier
 * @date 2022/1/16 0:01
 * @Copyright 韵达快递
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, (() -> {
            System.out.println("****龙珠齐，召唤神龙****");
        }));

        for (int i = 1; i <= 7; i++) {
            String name = String.valueOf(i);
            new Thread(() -> {
                System.out.println(name + "线程，龙珠集齐");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, name).start();
        }
    }

}
