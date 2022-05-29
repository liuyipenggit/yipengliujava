package com.yipeng.liu.juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类内部分别有 ReentrantLock 与 Synchronized 标记的不同方法
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.reenterlock
 * @date 2022/1/16 16:57
 * @Copyright 韵达快递
 */
public class Phone implements Runnable {

    public synchronized void sendQQ() {
        System.out.println(Thread.currentThread().getName() + "发QQ消息");
        sendWechat();
    }

    public synchronized void sendWechat() {
        System.out.println(Thread.currentThread().getName() + "发Wechat消息");
    }


    ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        try {
            reentrantLock.lock();
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void get() {
        System.out.println(Thread.currentThread().getName() + "调用get");
        set();
    }

    public void set() {
        System.out.println(Thread.currentThread().getName() + "调用set");
    }

}
