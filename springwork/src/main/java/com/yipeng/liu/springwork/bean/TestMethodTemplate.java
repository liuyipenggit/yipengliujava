package com.yipeng.liu.springwork.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板方法测试类
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.bean
 * @date 2022/5/4 14:36
 * @Copyright 韵达快递
 */
public class TestMethodTemplate {

    public static void main(String[] args) {

        MyBeanFactory myBeanFactory = new MyBeanFactory();
        myBeanFactory.addBeanPostProcessor(object -> {
            System.out.println("解析@Autowired");
        });
        myBeanFactory.addBeanPostProcessor(object -> {
            System.out.println("解析@Resource");
        });
        myBeanFactory.getBean();
    }

    static class MyBeanFactory {

        private List<BeanPostProcessor> postProcessors = new ArrayList<>();

        public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
            postProcessors.add(beanPostProcessor);
        }

        public Object getBean() {
            Object bean = new Object();
            System.out.println("构造" + bean);
            //处理@Autowired,@Resource
            System.out.println("依赖注入" + bean);
            postProcessors.forEach(o -> {
                o.inject(bean);
            });
            System.out.println("初始化" + bean);
            return bean;
        }

    }

    interface BeanPostProcessor {

        /**
         * 对依赖注入阶段的扩展
         *
         * @param object
         */
        void inject(Object object);

    }

}
