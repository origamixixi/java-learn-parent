package org.example.core.resources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClassPathResourceMain {

    public static void main(String[] args) throws Exception{
        // 访问类路径下资源
        Resource resource = new ClassPathResource("log4j2.xml");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
