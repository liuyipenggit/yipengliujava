package com.yipeng.liu.juc.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.readwritelock
 * @date 2022/1/15 16:51
 * @Copyright 韵达快递
 */
public class MyCache {
    /**
     * volatile：保证内存可见性，禁止指令重排
     */
    private volatile Map map = new HashMap<String, Object>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        try {
            readWriteLock.writeLock().lock();
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在写入数据，数据key" + key);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(name + "写入数据结束，数据key" + key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {

        Object o = null;
        try {
            readWriteLock.readLock().lock();
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在读取数据，数据key：" + key);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o = map.get(key);
            System.out.println(name + "读取数据结束，数据值：" + o);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return o;
    }
}
