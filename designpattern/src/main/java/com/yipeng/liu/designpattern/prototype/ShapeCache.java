package com.yipeng.liu.designpattern.prototype;

import java.util.Hashtable;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.prototype
 * @date 2021/12/24 10:45
 * @Copyright 韵达快递
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap
            = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    /**
     * 对每种形状都运行数据库查询，并创建该形状
     * shapeMap.put(shapeKey, shape);
     * 例如，我们要添加二种形状
     */
    public static void loadCache() {

        Square square = new Square();
        square.setId("1");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);

    }

}
