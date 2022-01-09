package com.yipeng.liu.designpattern.prototype;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.prototype
 * @date 2021/12/24 10:16
 * @Copyright 韵达快递
 */
public abstract  class Shape  implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
