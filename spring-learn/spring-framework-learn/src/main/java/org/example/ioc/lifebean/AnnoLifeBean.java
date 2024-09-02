package org.example.ioc.lifebean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnnoLifeBean implements InitializingBean, DisposableBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean destroy");
    }

    public String sayHello() {
        return "AnnoLifeBean say hello";
    }

    @PreDestroy
    public void cleanup() {
        log.info("@PreDestroy cleanup");
    }

    @PostConstruct
    public void init() {
        log.info("@PostConstruct init");
    }
}
