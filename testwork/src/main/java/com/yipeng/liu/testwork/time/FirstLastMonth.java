package com.yipeng.liu.testwork.time;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.testwork.time
 * @date 2021/10/15 13:44
 * @Copyright 韵达快递
 */
public class FirstLastMonth {

    public static void main(String[] args) {

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        //获取前月的第一天
//        Calendar cal_1=Calendar.getInstance();//获取当前日期
//        cal_1.add(Calendar.MONTH, -1);
//        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
//        String firstDay = format.format(cal_1.getTime());
//        System.out.println("-----1------firstDay:"+firstDay);
//
//        //获取前月的最后一天
//        Calendar cale = Calendar.getInstance();
//        cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
//        String lastDay = format.format(cale.getTime());
//        System.out.println("-----2------lastDay:"+lastDay);
//
        LocalDate today = LocalDate.now();
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime lastDayTime = localDateToLocalDateTime(lastDay);
        System.out.println(lastDayTime);
        System.out.println(localDateTime2YMDHMS(lastDayTime));

        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
        System.out.println(firstday.atStartOfDay());
//        System.out.println(firstday.at());
        LocalDateTime firstDayTime = localDateToLocalDateTime(firstday);
        System.out.println(firstDayTime);

//        Date date=new Date();
//        LocalDateTime last = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().with(TemporalAdjusters.lastDayOfMonth());
//        LocalDateTime first = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().with(TemporalAdjusters.firstDayOfMonth());
//        System.out.println(last);
//        System.out.println(first);
    }
    public static String localDateTime2YMDHMS(LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(localDateTime);
    }

    public static LocalDateTime localDateToLocalDateTime(LocalDate localDate) {

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date =  Date.from(instant);

        instant = date.toInstant();
        zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

}
