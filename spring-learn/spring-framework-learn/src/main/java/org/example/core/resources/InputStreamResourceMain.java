package org.example.core.resources;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class InputStreamResourceMain {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://blog.csdn.net/orixixi/article/details/134415954?spm=1001.2014.3001.5501");
        Resource resource = new InputStreamResource(url.openConnection().getInputStream());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
