package org.example.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AopMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        IJdkDynamicProxyBean jdkDynamicProxyBean = context.getBean(IJdkDynamicProxyBean.class);
        jdkDynamicProxyBean.sayHello();
        if (java.lang.reflect.Proxy.isProxyClass(jdkDynamicProxyBean.getClass())) {
            log.info("JdkDynamicProxyBean {}， 是JDK动态代理", jdkDynamicProxyBean.getClass());
        }

        log.info("----------------------------------------------------------------------------------------------------");

        CglibDynamicProxyBean cglibDynamicProxyBean = context.getBean(CglibDynamicProxyBean.class);
        cglibDynamicProxyBean.sayHello();
        if (org.springframework.cglib.proxy.Enhancer.isEnhanced(cglibDynamicProxyBean.getClass())) {
            log.info("CglibDynamicProxyBean {}，是CGLIB代理", cglibDynamicProxyBean.getClass());
        }
    }
}
