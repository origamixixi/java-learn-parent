package org.example.events;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventsMain {

    public static void main(String[] args) {
        // 启动容器 期间发布ContextRefreshedEvent
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 显示调用 发布ContextStartedEvent
        context.start();
        ExamplePublisher examplePublisher = context.getBean(ExamplePublisher.class);
        // 发布 自定义事件
        examplePublisher.publish();
        // 显示调用 发布ContextStoppedEvent
        context.stop();
        // 显示调用 发布ContextClosedEvent
        context.close();
    }
}
