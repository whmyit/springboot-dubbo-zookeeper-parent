package com.whmyit.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringBootApplication(scanBasePackages = {"com.whmyit.*"}) 多项目中扫描注解
 */
@SpringBootApplication(scanBasePackages = {"com.whmyit.*"})
@ImportResource("classpath:consumer.xml")
public class SpringDubboClientApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringDubboClientApplication.class, args);
		System.out.println("---------------------------------------------");
	}

}
