package com.yipeng.liu.juc.reentrantlock;

import java.util.concurrent.TimeUnit;

/**
 * ReentrantLock 与 synchronized 都是可重入锁（也叫递归锁）
 * 指的是同一个线程外层函数获得锁之后，内层递归函数依然能获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 * 也就是说，线程可以进入任何他已经拥有锁的锁所同步这的代码块
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.reenterlock
 * @date 2022/1/16 16:40
 * @Copyright 韵达快递
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendQQ();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.sendQQ();
        }, "B").start();

        new Thread(phone).start();
        new Thread(phone).start();


    }

}
