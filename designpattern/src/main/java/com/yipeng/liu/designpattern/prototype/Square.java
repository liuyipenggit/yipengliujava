package com.yipeng.liu.designpattern.prototype;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.prototype
 * @date 2021/12/24 10:42
 * @Copyright 韵达快递
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
