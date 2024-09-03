package org.example.core.resources;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileSystemResourceMain {

    public static void main(String[] args) throws Exception {
        // 访问文件系统资源
        // 相对路径
        Resource resource = new FileSystemResource("spring-learn\\spring-framework-learn\\src\\main\\resources\\log4j2.xml");
        // 绝对路径
        // Resource resource = new FileSystemResource("D:\\spring-learn\\spring-framework-learn\\src\\main\\resources\\log4j2.xml");
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
