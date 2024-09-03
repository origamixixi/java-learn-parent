package org.example.core.ioc.scanbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ScanBeanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-scanbean.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrder();
    }
}
