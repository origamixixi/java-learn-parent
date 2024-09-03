package org.example.core.resources;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UrlResourceMain {

    public static void main(String[] args) throws Exception {
        // 访问网络资源
        Resource resource = new UrlResource("https://blog.csdn.net/orixixi/article/details/134415954?spm=1001.2014.3001.5501");
        System.out.println(resource.getFilename());
        System.out.println(resource.getURI());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
