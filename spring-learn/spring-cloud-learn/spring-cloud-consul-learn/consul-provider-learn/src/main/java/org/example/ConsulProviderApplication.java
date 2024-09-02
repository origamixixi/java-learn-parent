package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConsulProviderApplication {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Service Provider!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class, args);
        System.out.println("consul ui： http://localhost:8500");
    }
}