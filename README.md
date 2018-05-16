# springboot-dubbo-zookeeper-parent spring boot 多模块

1.用maven 控制jar包的版本统一

2.多模块化项目 
  ----  spring-dubbo-client  消费者
     ---- 项目启动时注册dubbo的服务到zookeeper 
  ----  spring-dubbo-service 生产者
     ---- 配置pom文件依赖消费者的service
     ---- 调用zookeeper中的dubbo服务
     
