package com.yipeng.liu.springwork.beanAfter;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * bean 后处理器的作用
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanAfter
 * @date 2022/5/4 20:44
 * @Copyright 韵达快递
 */
public class AfterProcessorApplication {

    public static void main(String[] args) {
        //GenericApplicationContext是一个【干净】的容器
        GenericApplicationContext context = new GenericApplicationContext();

        //初始化容器
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        //context.registerBean("bean4", Bean4.class);

        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(
                new ContextAnnotationAutowireCandidateResolver()
        );
        //解析@Autowired @Value
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        //@Resource @PostConstruct @PreDestroy
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        //@ConfigurationProperties
        //ConfigurationPropertiesBindingPostProcessor.register(
        //        context.getDefaultListableBeanFactory()
        //);

        //销毁容器
        //执行beanFactory后处理器，添加bean后处理器，初始化所有单例
        context.refresh();

        System.out.println(context.getBean(Bean4.class));

        //销毁容器
        context.close();

    }

}
