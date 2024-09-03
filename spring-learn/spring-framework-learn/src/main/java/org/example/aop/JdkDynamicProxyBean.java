package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JdkDynamicProxyBean implements IJdkDynamicProxyBean {

    public void sayHello() {
        log.info("JdkDynamicProxyBean say hello");
    }
}
