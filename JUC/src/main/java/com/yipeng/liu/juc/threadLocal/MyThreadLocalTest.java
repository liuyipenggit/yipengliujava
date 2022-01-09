package com.yipeng.liu.juc.threadLocal;

/**
 * 需求：线程隔离
 * --》在多线程并发场景下，每个线程中的变量都是相互独立的
 * --》线程A: 设置（变量1） 获取（变量1）
 * --》线程B: 设置（变量2） 获取（变量2）
 * <p>
 * -->ThreadLocal:
 * -->1.set():讲变量绑定到当前线程中
 * -->2.get()：获取当前线程绑定的变量
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.juc.threadLocal
 * @date 2021/10/25 21:16
 * @Copyright 韵达快递
 */
public class MyThreadLocalTest {

    ThreadLocal<String> t = new ThreadLocal<>();

    /**
     * 变量
     */
    private String content;

    private String getContent() {
        return t.get();
    }

    private void setContent(String content) {
        t.set(content);
    }

    public static void main(String[] args) {

        MyThreadLocalTest myThreadLocalTest = new MyThreadLocalTest();

        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    myThreadLocalTest.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("---------------------------------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + myThreadLocalTest.getContent());
                }
            });

            thread.setName("线程"+i);
            thread.start();

        }


    }

}
