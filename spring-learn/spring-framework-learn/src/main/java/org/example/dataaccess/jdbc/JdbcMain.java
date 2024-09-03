package org.example.dataaccess.jdbc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class JdbcMain {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        log.info("{}", userRepository.listAllRoleNames());
    }
}
