＃springboot-dubbo-zookeeper-parent spring boot多模块

##############################
2018年5月22日  
------------------------------
1.添加多模块打包支持 common 公用类

2.修改POM文件内容


##############################
2018年5月8日
------------------------------
1.用行家控制罐包的版本统一

2.多模块化项目 
  ----  spring-dubbo-client  消费者
     ---- 项目启动时注册dubbo的服务到zookeeper 
  ----  spring-dubbo-service 生产者
     ---- 配置pom文件依赖消费者的service
     ---- 调用zookeeper中的dubbo服务     
