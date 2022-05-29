package com.yipeng.liu.springwork.beanAfter;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;

/**
 * AutowiredAnnotationBeanPostProcessor运行分析
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanAfter
 * @date 2022/5/4 23:43
 * @Copyright 韵达快递
 */
public class DigInAutowired {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //认为注入的bean是成品的，不会走：创建过程，依赖注入，初始化
        beanFactory.registerSingleton("bean2",new Bean2());
        beanFactory.registerSingleton("bean3",new Bean3());
        //获取@Value
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());

        //1.查找那些属性，方法加了@Autowired,这称之为InjectionMetadata
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setBeanFactory(beanFactory);

        Bean1 bean1 = new Bean1();
        
        //2.调用

    }

}
