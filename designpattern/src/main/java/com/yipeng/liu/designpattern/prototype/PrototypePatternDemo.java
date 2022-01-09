package com.yipeng.liu.designpattern.prototype;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.prototype
 * @date 2021/12/24 10:47
 * @Copyright 韵达快递
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape2 = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape3.getType());

    }

}
