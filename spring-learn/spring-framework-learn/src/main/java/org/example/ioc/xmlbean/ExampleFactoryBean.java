package org.example.ioc.xmlbean;

import org.springframework.beans.factory.FactoryBean;

public class ExampleFactoryBean implements FactoryBean<ExampleFactoryBean.ExampleBean> {

    @Override
    public ExampleBean getObject() throws Exception {
        return new ExampleBean();
    }

    @Override
    public Class<?> getObjectType() {
        return ExampleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    public static class ExampleBean {
        public String sayHello() {
            return "ExampleBean say hello";
        }
    }
}
