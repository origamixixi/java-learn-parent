[Spring Cloud Consul Config](https://spring.io/projects/spring-cloud-consul)
====

# 1. 安装
下载地址：https://www.consul.io/downloads.html

windows环境下，单机启动命令：
```agsl
consul agent -dev -ui -client=0.0.0.0
```
- server 以服务端身份启动(注册中心)
- bind 表示绑定到哪个IP
- client 指定客户端访问的IP，0.0.0.0 表示不限制客户端IP
- ui 开启web界面访问
- bootstrap-expect=3 表示server集群最低节点数3，低于这个值将工作不正常
- data-dir 指定数据存放的路径，该目录必须存在，需提前创建好，持久化数据
- node 表示节点在web ui显示的名称

web管理界面
```agsl
http://localhost:8500
```

# 2. 使用
pom文件依赖
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-consul-all</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```


# 3. 功能
## 3.1 服务注册与发现
pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-discovery</artifactId>
</dependency>
```

## 3.2 配置中心
pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-config</artifactId>
</dependency>
```

## 3.3 健康检查
pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
