package com.yipeng.liu.testwork.controller;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu.testwork.controller
 * @date 2021/7/30 9:57
 * @Copyright 韵达快递
 */
public class TestMap {

    private static ArrayList<HashMap<Integer, String>> paseMapList() {
        HashMap<Integer, String> map1 = new HashMap(8) {{
            put(1, "张三");
        }};
        HashMap<Integer, String> map2 = new HashMap(8) {{
            put(2, "李四");
        }};
        HashMap<Integer, String> map3 = new HashMap(8) {{
            put(3, "王五");
        }};
        ArrayList<HashMap<Integer, String>> list = new ArrayList() {{
            add(map1);
            add(map2);
            add(map3);
        }};
        return list;
    }

}
