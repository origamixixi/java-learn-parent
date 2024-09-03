package org.example.core.ioc.xmlbean;

public class DynamicFactory {

    public DynamicFactoryBean createInstance() {
        return new DynamicFactoryBean();
    }

    public static class DynamicFactoryBean {

        public String sayHello() {
            return "DynamicFactoryBean say hello";
        }
    }
}
