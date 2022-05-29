package com.yipeng.liu.juc.spin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现自旋锁
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.spin
 * @date 2022/1/15 17:45
 * @Copyright 韵达快递
 */
public class SpinLockTest {

    /**
     * 原子引用线程
     */
    private AtomicReference<Thread> threadAtomicReference=new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"尝试获取锁");
        while (!threadAtomicReference.compareAndSet(null, thread)) {
            System.out.println(thread.getName()+"自旋获取锁");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(thread.getName()+"获取锁成功");
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"尝试释放锁");
        if (threadAtomicReference.compareAndSet(thread,null)) {
            System.out.println(thread.getName()+"释放锁成功");
        }
    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();

        new Thread(()->{
            spinLockTest.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockTest.myUnLock();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockTest.myLock();
            spinLockTest.myUnLock();
        },"B").start();

    }
}
