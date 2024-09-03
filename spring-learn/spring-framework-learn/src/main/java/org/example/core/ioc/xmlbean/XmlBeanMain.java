package org.example.core.ioc.xmlbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class XmlBeanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-xmlbean.xml");
        NoArgsConstructorBean noArgsConstructorBean = context.getBean(NoArgsConstructorBean.class);
        log.info("无参构造, {}", noArgsConstructorBean.sayHello());

        ArgsConstructorBean argsConstructorBean = context.getBean(ArgsConstructorBean.class);
        log.info("有参构造, {}", argsConstructorBean.sayHello());

        StaticFactory.StaticFactoryBean staticFactoryBean = context.getBean(StaticFactory.StaticFactoryBean.class);
        log.info("静态工厂, {}", argsConstructorBean.sayHello());

        DynamicFactory.DynamicFactoryBean dynamicFactoryBean = context.getBean(DynamicFactory.DynamicFactoryBean.class);
        log.info("动态工厂, {}", dynamicFactoryBean.sayHello());

        ExampleFactoryBean.ExampleBean exampleBean = context.getBean(ExampleFactoryBean.ExampleBean.class);
        log.info("工厂bean, {}", exampleBean.sayHello());
    }
}
