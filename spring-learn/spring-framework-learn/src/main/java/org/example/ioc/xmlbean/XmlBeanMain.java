package org.example.ioc.xmlbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class XmlBeanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-xmlbean.xml");
        NoArgsConstructorBean noArgsConstructorBean = context.getBean(NoArgsConstructorBean.class);
        log.info(noArgsConstructorBean.sayHello());

        ArgsConstructorBean argsConstructorBean = context.getBean(ArgsConstructorBean.class);
        log.info(argsConstructorBean.sayHello());

        StaticFactory.StaticFactoryBean staticFactoryBean = context.getBean(StaticFactory.StaticFactoryBean.class);
        log.info(staticFactoryBean.sayHello());

        DynamicFactory.DynamicFactoryBean dynamicFactoryBean = context.getBean(DynamicFactory.DynamicFactoryBean.class);
        log.info(dynamicFactoryBean.sayHello());

        ExampleFactoryBean.ExampleBean exampleBean = context.getBean(ExampleFactoryBean.ExampleBean.class);
        log.info(exampleBean.sayHello());

        String[] beanNamesForType = context.getBeanNamesForType(StaticFactory.StaticFactoryBean.class);
        for (String beanName : beanNamesForType) {
            log.info("beanName: {}", beanName);
        }
    }
}
