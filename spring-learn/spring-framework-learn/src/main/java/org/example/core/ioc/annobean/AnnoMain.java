package org.example.core.ioc.annobean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoBeanConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.sayHello();
    }
}
