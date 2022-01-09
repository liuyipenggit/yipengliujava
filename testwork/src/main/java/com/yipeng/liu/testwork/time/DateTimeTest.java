package com.yipeng.liu.testwork.time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.testwork.time
 * @date 2021/8/31 17:56
 * @Copyright 韵达快递
 */
public class DateTimeTest {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        Date date1 = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        String text = date.format(formatter);
        System.out.println("名字"+format1);
    }
}
