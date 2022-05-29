package com.yipeng.liu.juc.blockingquery;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列：共有七种，也即是线程池的队列，常用的为以下三种
 * ArrayBlockingQuery:是一个基于数组结构的有界阻塞队列，此队列按照FIFO（先进先出）原则对数据进行排序
 * LinkedBlockingQuery：是一个基于链表结构的阻塞队列，此队列按FIFO（先进先出）排序元素，吞吐量通常要高于ArrayFIFO（先进先出）
 * SynchronousQuery：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态。
 * 添加 移除 查看
 * add,  remove,element 抛异常
 * offer,poll,  peek    返回false
 * put,  take,  无       阻塞(消息中间件可用)
 * offer,poll,  无       超时返回false
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.blockingquery
 * @date 2022/1/16 20:46
 * @Copyright 韵达快递
 */
public class BlockingQueryTest {

    public static void main(String[] args) throws InterruptedException {
//        arrayBlockingQueue();

        synchronousQueue();

    }

    /**
     * 阻塞队列列api简单实用
     */
    private static void arrayBlockingQueue() {
        BlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(2);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.element());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * 阻塞队列实现简单生产者消费者
     *
     * @throws InterruptedException
     */
    private static void synchronousQueue() throws InterruptedException {

        BlockingQueue<Object> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "放入1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "放入2");
                synchronousQueue.put("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "获取" + synchronousQueue.poll());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "获取" + synchronousQueue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }

}
