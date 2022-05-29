package com.yipeng.liu.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore
 * 信号量主要用于两个目的，一个适用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.semaphore
 * @date 2022/1/16 0:17
 * @Copyright 韵达快递
 */
public class SemaphoreTest {

    /**
     * 模拟六个车强三个车位
     *
     * @param args
     */
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "车开走，释放车位");
                    semaphore.release();
                }
            }, String.valueOf(i)).start();

        }
    }

}
