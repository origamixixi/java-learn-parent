package org.example.core.ioc.lifebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class LifeBeanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeBeanConfig.class);
        LifeBean lifeBean = context.getBean(LifeBean.class);
        log.info(lifeBean.sayHello());
        context.close();
    }
}
