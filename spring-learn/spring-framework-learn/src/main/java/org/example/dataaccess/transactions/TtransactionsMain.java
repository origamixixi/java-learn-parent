package org.example.dataaccess.transactions;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TtransactionsMain {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        log.info("{}", userRepository.listAllRoleNames());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
            userRepository.createRole("剑士");
        });
        cf1.join();
        log.info("{}", userRepository.listAllRoleNames());

        // 回滚
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            userRepository.createRole(UserRepository.CHEAT);
        }, executorService).exceptionally(ex -> {
            log.info("{}", ex.getMessage());
            return null;
        });
        cf2.join();
        log.info("{}", userRepository.listAllRoleNames());

        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> {
            userRepository.createRole("咒术师");
        }, executorService);
        cf3.join();
        log.info("{}", userRepository.listAllRoleNames());

        executorService.shutdown();
    }
}
