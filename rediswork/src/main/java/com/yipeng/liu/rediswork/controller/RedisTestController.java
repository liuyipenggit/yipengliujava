package com.yipeng.liu.rediswork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.rediswork.controller
 * @date 2021/8/5 18:15
 * @Copyright 韵达快递
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping()
    public String testRedis(){
        redisTemplate.opsForValue().set("name","lyp");
        return (String) redisTemplate.opsForValue().get("name");
    }

}
