package com.yipeng.liu.juc.deallock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁例子
 * 死锁的四个必要条件：
 * （1） 互斥条件：一个资源每次只能被一个进程使用。
 * （2） 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * （3） 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
 * （4） 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.deallock
 * @date 2022/1/19 22:17
 * @Copyright 韵达快递
 */
public class DealLockTest {

    private static String lock1 = "lock1";
    private static String lock2 = "lock2";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "锁lock1");
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "尝试lock2");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "锁lock2");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "尝试lock1");
                }
            }
        }, "B").start();

    }

}
