package org.example.core.ioc.xmlbean;

public class ArgsConstructorBean {

    private NoArgsConstructorBean noArgsConstructorBean;

    public ArgsConstructorBean(NoArgsConstructorBean noArgsConstructorBean) {
        this.noArgsConstructorBean = noArgsConstructorBean;
    }

    public String sayHello() {
        return String.format("ArgsConstructorBean say hello and %s", noArgsConstructorBean.sayHello());
    }
}
