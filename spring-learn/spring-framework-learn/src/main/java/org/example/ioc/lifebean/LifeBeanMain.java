package org.example.ioc.lifebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class LifeBeanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeBeanConfig.class);
        AnnoLifeBean annoLifeBean = context.getBean(AnnoLifeBean.class);
        log.info(annoLifeBean.sayHello());
        context.close();
    }
}
