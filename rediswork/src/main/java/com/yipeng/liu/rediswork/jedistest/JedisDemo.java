package com.yipeng.liu.rediswork.jedistest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.rediswork.jedis
 * @date 2021/8/5 15:37
 * @Copyright 韵达快递
 */
public class JedisDemo {



    @Test
    public void demo1() {
        Jedis jedis = new Jedis("10.16.10.91", 6379);
        System.out.println(jedis.ping());

        Set<String> keys = jedis.keys("*");
        keys.forEach(o -> {
            System.out.println(o);
        });
    }

}
