package com.yipeng.liu.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch主要有两个方法，当一个或者多个线程数调用await方法时，调用线程会被阻塞。
 * 其他线程调用countDown方法将会将计数器减1（调用countDown方法的线程不会阻塞）、
 * 当计数器的值变为0时，因调用await方法被阻塞的线程会被唤醒，继续执行（lock support实现）
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.countdownlatch
 * @date 2022/1/15 18:47
 * @Copyright 韵达快递
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"国被灭亡");
            },CountryEnum.getDescEnum(String.valueOf(i))).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"秦国扫六合，统一全国");
    }

}
