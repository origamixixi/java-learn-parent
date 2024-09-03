package org.example.core.resources;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResourceLoaderAwareMain {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        context.registerBean(InnerClass.class);
        InnerClass innerClass = context.getBean(InnerClass.class);
        ResourceLoader resourceLoader = innerClass.getResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:spring-xmlbean.xml");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    class InnerClass implements ResourceLoaderAware {

        private ResourceLoader resourceLoader;

        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }

        public ResourceLoader getResourceLoader() {
            return resourceLoader;
        }
    }
}
