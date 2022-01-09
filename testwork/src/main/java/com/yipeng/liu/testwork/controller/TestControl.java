package com.yipeng.liu.testwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.testwork.controller
 * @date 2021/8/20 14:51
 * @Copyright 韵达快递
 */
@RestController
public class TestControl {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
