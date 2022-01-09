package com.yipeng.liu.designpattern.meituan.module;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.module
 * @date 2022/1/5 20:11
 * @Copyright 韵达快递
 */
public enum UserTypeEnum {

    NEW_USER(1, "营销活动"),

    OLD_USER(2, "客服系统");

    private int code;

    private String desc;

    UserTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
