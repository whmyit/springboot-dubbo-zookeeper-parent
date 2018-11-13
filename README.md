＃springboot-dubbo-zookeeper-seckill spring boot多模块 秒杀业务


多模块化项目 
  ----  spring-dubbo-client  消费者
  
     ---- 项目启动时注册dubbo的服务到zookeeper 
     
  ----  spring-dubbo-service 生产者
  
     ---- 配置pom文件依赖消费者的service
     ---- 调用zookeeper中的dubbo服务     
     
  ----   spring-dubbo-api    公用 
  
  
  
## spring-dubbo-api

    /constant  目录包含可能常用的常量
        ConstChar   用于文本的编码格式  ConstChar.GBK， ConstChar.UTF_8 等
        
    /entity    多模块通用的实体类
    
    /util      锁模块通用的工具类
        FileUtils   用于文件的操作 如复制 等
        
    /service   服务接口类 提供所有服务的接口
    


## 添加秒杀Seckill 相关内容
    
    秒杀业务功能
            1.秒杀商品列表
            2.秒杀商品详情
            3.用户执行秒杀
            4.秒杀结果
    
    dao功能
            1.查询秒杀列表
            2.查询所有秒杀        
            3.插入秒杀记录
            4.更新库存
    
        
        
   