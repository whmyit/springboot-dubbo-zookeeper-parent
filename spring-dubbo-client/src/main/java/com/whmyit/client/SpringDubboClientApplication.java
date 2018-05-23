package com.whmyit.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.whmyit.api.service.InfoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource("classpath:consumer.xml")
@RestController
public class SpringDubboClientApplication {

	@Reference
	InfoService infoService;

	@GetMapping("/test")
	public Object canBuy(){
		return infoService.getAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDubboClientApplication.class, args);
	}
}
