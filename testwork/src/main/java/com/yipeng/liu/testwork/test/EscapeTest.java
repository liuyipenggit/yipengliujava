package com.yipeng.liu.testwork.test;

/**
 * 逃逸分析
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.testwork.test
 * @date 2021/11/12 17:25
 * @Copyright 韵达快递
 */
public class EscapeTest {
    public String test() {
        User user = new User();
        user.setAge(123);
        user.setName("sdfsdf");
        return user.getAge() + user.getName();

    }

    //锁消除
    //标量替换(scalr replacement of aggregates)//标量替换聚合量
    //栈上分配

    class User {
        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
