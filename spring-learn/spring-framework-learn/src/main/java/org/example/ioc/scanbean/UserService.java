package org.example.ioc.scanbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    public void sayHello() {
        log.info("hello");
    }
}
