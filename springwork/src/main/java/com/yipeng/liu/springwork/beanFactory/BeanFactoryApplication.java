package com.yipeng.liu.springwork.beanFactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * BeanFactory与FactoryBean
 * <p>
 * BeanFactory：是接口，提供了IOC容器最基本的形式，给具体的IOC容器的实现提供了规范，顶层接口
 * a.BeanFactory不会做的事
 * ->1.不会主动调用BeanFactory后置处理器
 * ->2.不会主动添加Bean后置处理器
 * ->3.不会主动初始化单例
 * ->4.不会解析beanFactory 还不会解析 %{} 与#{}
 * b.bean后置处理器会有排序的逻辑（@Autowired在@Resource前执行）
 * 补充了一些bean定义
 * <p>
 * FactoryBean ：也是接口，为IOC容器中Bean的实现提供了更加灵活的方式，FactoryBean在IOC容器的基础上给Bean的实现加上了一个简单的工厂模式和装饰模式 ，我们可以在getObject()方法中灵活配置
 *
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.springwork.beanFactory
 * @date 2022/4/18 22:49
 * @Copyright 韵达快递
 */
@SpringBootApplication
public class BeanFactoryApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {

        ConfigurableApplicationContext context = SpringApplication.run(BeanFactoryApplication.class);

        /*
        1.什么是 BeanFactory？
        -他是ApplicationContext的父接口
        -他才是spring的核心容器，主要的applicationContext实现都【组合】了它的功能
         */
        System.out.println(context);

        /*
        2.BeanFactory 能干什么？
        -表面上只有getBean
        -实际上控制反转，基本的依赖注入，甚至Bean的生命周期的各种功能，都有它的实现类提供
         */
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
        map.entrySet().stream().filter(e -> e.getKey().startsWith("component")).forEach(e -> {
            System.out.println(e.getKey() + "=" + e.getValue());
        });

        /*
        3.ApplicationContext 比 BeanFactory 多点什么？
        国际化相关功能，前提是需要提前配置message.properties
        System.out.println(context.getMessage("java", null, Locale.CHINA));
        System.out.println(context.getMessage("java", null, Locale.ENGLISH));
         */
        //classpath:类路径资源下寻找；file:文件路径下寻找
        Resource contextResource = context.getResource("classpath:application.properties");
        System.out.println("application.properties文件在：" + contextResource);
        //添加*作为通配符可导jar包中寻找
        Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
        for (Resource resource : resources) {
            System.out.println("spring.factories文件位置：" + resource);
        }

        //Environment:获取配置信息
        System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("server.port"));

        //main方法context做事件发布
        //context.publishEvent(new UserRegisteredEvent(context));
        context.getBean(Component1.class).register();

        /*
        4.小结：
        a.BeanFactory 与 ApplicationContext 并不仅仅是简单接口继承的关系，ApplicationContext 组合并扩展了 BeanFactory 的功能
        b.事件是新的代码解耦途径
         */

    }

}
