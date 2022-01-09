package com.yipeng.liu.designpattern.prototype;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.prototype
 * @date 2021/12/24 10:43
 * @Copyright 韵达快递
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
