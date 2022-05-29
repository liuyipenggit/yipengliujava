package com.yipeng.liu.juc.syncandlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：synchronized 和 Lock 的区别
 * 1.原始构成
 * -->synchronized 是关键字，属于JVM层面（通过 monitorenter monitorexit 两个命令实现）。
 * ---->底层通过monitor对象来完成，起始wait/notify等方法也依赖于monitor对象只有在同步代码块或方法中才能调用wait/notify等方法
 * -->Lock 是具体的类（java.util.concurrent.locks）时api层面的锁
 * 2.使用方法
 * -->synchronized 不需要用户手动释放锁，当 synchronized 代码执行完成后系统会自动让线程释放对锁的占用
 * -->Lock 则需要用户手动去释放锁，若没有释放有可能导致死锁
 * 3.等待是否可中断
 * -->synchronized 不可中断，除非抛异常或者正常运行完成
 * -->Lock 可中断。
 * ---->a.设置超时方法tryLock(long timeout,TimeUnit unit)
 * ---->b.lockInterruptibly()放代码块中，调用interrupt()方法可中断
 * 4.加锁是否公平
 * -->synchronized 非公平锁
 * -->Lock 默认非公平锁，构造方法可传入boolean值，true:公平;false:非公平
 * 5.锁绑定多个条件Condition
 * -->synchronized 没有
 * -->Lock 用来实现分组唤醒需要唤醒线程们，可以精确唤醒，而不是像synchronized要么随机唤醒要么全部唤醒
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.syncandlock
 * @date 2022/1/16 23:20
 * @Copyright 韵达快递
 */
public class SyncAndLockTest {


    public static void main(String[] args) {
        demo01();
        demo02();
    }

    /**
     * 题目：多线程之间按顺序调用，实现A->B->C三个线程启动
     * 要求：A打印1次，B打印3次，C打印5次。循环三轮
     */
    private static void demo02() {

    }

    /**
     * 题目:一个初始值为0的变量,两个线程对其交替操作,一个加1一个减1,来5轮
     * ReentrantLock 与 synchronized 都可实现
     */
    private static void demo01() {
        A a = new A();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                a.increment();
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                a.decrement();
            }
        }, "B").start();
    }

    static class A {

        private Integer number = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        //        标志位为0-操作A
        private Condition c1 = lock.newCondition();
        //        标志位为1-操作B
        private Condition c2 = lock.newCondition();
        //        标志位为2-操作C
        private Condition c3 = lock.newCondition();

        /**
         * 自增
         */
        public void increment() {
            try {
                lock.lock();
//            判断
                while (number != 0) {
//                等待,不能生产
                    condition.await();
                }
//            干活
                number++;
                System.out.println(Thread.currentThread().getName() + "线程，操作后数量：" + number);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 自减
         */
        public void decrement() {
            try {
                lock.lock();
//            判断
                while (number == 0) {
//                等待,不能消费
                    condition.await();
                }
//            干活
                number--;
                System.out.println(Thread.currentThread().getName() + "线程，操作后数量：" + number);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 精准唤醒所需要的线程
         */
        public void print() {
            try {
                lock.lock();
                while (number != 0) {
                    c1.await();
                }
                for (int i = 0; i < 1; i++) {
                    System.out.println("A");
                }
                number = 1;
                c2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }

    }

}
