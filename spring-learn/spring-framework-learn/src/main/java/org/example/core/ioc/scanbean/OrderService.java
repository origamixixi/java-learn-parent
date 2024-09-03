package org.example.core.ioc.scanbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderService {

    @Autowired
    private UserService userService;

    public void createOrder() {
        log.info("{} create order", userService.getUserName());
    }
}
