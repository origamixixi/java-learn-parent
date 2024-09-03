package org.example.core.i18n;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class I18nMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object[] objs = new Object[]{"World", new Date().toString()};

        String str = context.getMessage("sayhello", objs, Locale.CHINA);
        System.out.println(str);

        String str2 = context.getMessage("sayhello", objs, Locale.US);
        System.out.println(str2);
    }
}
