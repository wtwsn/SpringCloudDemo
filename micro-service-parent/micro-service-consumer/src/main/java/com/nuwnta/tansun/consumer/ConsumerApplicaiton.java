package com.nuwnta.tansun.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient消费者添加该注解用于获取微服务列表
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplicaiton {
	public static void main(String[] args) {
		System.out.println("--------------- micro-service-consumer start ---------------------");
		SpringApplication.run(ConsumerApplicaiton.class, args);
		System.out.println("--------------- micro-service-consumer end ---------------------");
	}
}
