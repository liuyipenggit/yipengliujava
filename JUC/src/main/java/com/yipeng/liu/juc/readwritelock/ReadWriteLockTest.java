package com.yipeng.liu.juc.readwritelock;

/**
 * 多个线程同时读一个资源类没问题，问了满足并发量，读取共享资源可以同时进行
 * 但是有一个线程想写共享资源类，就不应该再有其他线程可以对该资源进行读或写
 * 小总结：
 * 读-读能共存
 * 读-写不共存
 * 写-写不共存
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.readwritelock
 * @date 2022/1/15 16:29
 * @Copyright 韵达快递
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {

            final String key = String.valueOf(i);
            new Thread(() -> {
                myCache.put(key, "value" + key);
                myCache.get(key);
            }, key).start();

        }

    }


}
