package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ConsulConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsulConsumerApplication.class, args);
        RestTemplate restTemplate = context.getBean(RestTemplate.class);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://consul-provider-service/hello", String.class);
        System.out.println(responseEntity.getBody());
    }
}