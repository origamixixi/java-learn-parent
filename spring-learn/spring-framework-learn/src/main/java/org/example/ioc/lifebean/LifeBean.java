package org.example.ioc.lifebean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Slf4j
@Component
public class LifeBean implements InitializingBean, DisposableBean,
        BeanNameAware, BeanFactoryAware, BeanClassLoaderAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware, ApplicationStartupAware, ApplicationContextAware {


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

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        log.info("BeanNameAware setBeanName");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("BeanClassLoaderAware setBeanClassLoader");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("ApplicationEventPublisherAware setApplicationEventPublisher");
    }

    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        log.info("ApplicationStartupAware setApplicationStartup");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("EmbeddedValueResolverAware setEmbeddedValueResolver");
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("EnvironmentAware setEnvironment");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        log.info("MessageSourceAware setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("ResourceLoaderAware setResourceLoader");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextAware setApplicationContext");
    }
}
