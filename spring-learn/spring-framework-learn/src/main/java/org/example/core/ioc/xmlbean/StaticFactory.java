package org.example.core.ioc.xmlbean;

public class StaticFactory {

    public static StaticFactoryBean createInstance() {
        return new StaticFactoryBean();
    }

    public static class StaticFactoryBean {

        public String sayHello() {
            return "StaticFactoryBean say hello";
        }
    }
}
