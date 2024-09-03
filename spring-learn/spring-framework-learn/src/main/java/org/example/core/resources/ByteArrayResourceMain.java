package org.example.core.resources;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteArrayResourceMain {

    public static void main(String[] args) {
        Resource resource = new ByteArrayResource("Hello, World!".getBytes());

        // 读取并打印内容
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("发生异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}