## Spring cloud

工程详解

/dubbo-api 

​	为服务创建的apiService 

/rocket-consumer

​	消费者

/rocket-produce 

​	生产者

## 集成组件

1.spring data jpa

2.spring cloud alibaba rocketmq

3.spring cloud alibaba seata

4.spring cloud alibaba nacos

5.spring cloud alibaba dubbo [现在是apache]

6.spring cloud stream

7.spring boot thymeleaf

## 运行目录

### mysql

consumer 和 produce 中`bootstrap.yml` 需要修改：

```yam
 url: jdbc:mysql://127.0.0.1:3306/tiny-crm?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&serverTimezone=Asia/Shanghai
 username: name
 password: password
```

### nacos

需要新增

service.vgroupMapping.tiny-erp=default

service.vgroupMapping.tiny-crm=default

${application.name}=tiny-erp



