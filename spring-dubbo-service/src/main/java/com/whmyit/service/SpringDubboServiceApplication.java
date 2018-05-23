package com.whmyit.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@MapperScan("com.whmyit.service.dao")//将项目中对应的mapper类的路径加进来就可以了
@ImportResource("classpath:providers.xml")
public class SpringDubboServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDubboServiceApplication.class, args);
		Thread.sleep(Long.MAX_VALUE);//pom中没有加spring-boot-starter-web依赖，启动时没有tomcat容器，会自动退出，所以加了一
	}
}
