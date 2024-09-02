package org.example.ioc.scanbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ScanBeanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-scanbean.xml");
        UserService userService = context.getBean(UserService.class);
        userService.sayHello();
    }
}
