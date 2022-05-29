package com.yipeng.liu.juc.countdownlatch;

import lombok.Getter;

/**
 * 国家枚举
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.juc.countdownlatch
 * @date 2022/1/15 18:55
 * @Copyright 韵达快递
 */
public enum CountryEnum {

    ONE("1", "齐"),
    TWO("2", "楚"),
    Three("3", "燕"),
    four("4", "韩"),
    five("5", "赵"),
    six("6", "魏");

    @Getter
    private String code;

    @Getter
    private String desc;

    CountryEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescEnum(String code) {
        for (CountryEnum countryEnum : CountryEnum.values()) {
            if (countryEnum.getCode().equalsIgnoreCase(code)) {
                return countryEnum.getDesc();
            }
        }
        return null;
    }


}
