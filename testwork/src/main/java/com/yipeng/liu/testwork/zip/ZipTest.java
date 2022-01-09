package com.yipeng.liu.testwork.zip;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.testwork.zip
 * @date 2021/9/6 9:20
 * @Copyright 韵达快递
 */
public class ZipTest {

    public static void main(String[] args) {
        String s1 = "D:\\data\\export";
        List<String> srcFiles = Arrays.asList(
                s1 + "\\coupons_template1.xlsx",
                s1 + "\\coupons_template2.xlsx",
                s1 + "\\coupons_template3.xlsx");
        try {
            ExportZipUtil.zipList(srcFiles, s1 + "\\coupons_template.zip");
        } catch (IOException e) {
        }
    }

}
