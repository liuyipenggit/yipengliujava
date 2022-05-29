package com.yipeng.liu.springwork.bean;

import com.yipeng.liu.springwork.beanFactory.Component1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义Bean后处理器
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.bean
 * @date 2022/5/4 12:44
 * @Copyright 韵达快递
 */
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    public static final Logger log = LoggerFactory.getLogger(Component1.class);

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("销毁之前执行，如@PreDestroy");
        }
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("实例化之前执行，这里返回的对象会替换掉原本的bean");
        }
        return null;
        //return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("实例化之后执行，这里如果返回false会跳过依赖注入阶段");
            //return true;
        }
        return true;
        //return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("依赖注入阶段执行，如@Autowired,@Value,@Resource");
        }
        return pvs;
        //return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("初始化之前，这里返回的对象会替换掉原本的bean，如@postConstruct,@ConfigurationProperties");
        }
        return bean;
        //return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycleBean")) {
            log.info("初始化之后，这里返回的对象会替换掉原本的bean,如代理增强");
        }
        return bean;
        //return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
