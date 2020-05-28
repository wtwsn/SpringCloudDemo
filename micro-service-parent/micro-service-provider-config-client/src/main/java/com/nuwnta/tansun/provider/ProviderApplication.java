package com.nuwnta.tansun.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {
	public static void main(String[] args) {
		//@EnableEurekaClient是将本工程作为微服务注册进eureka注册中心。
		System.out.println("--------------- micro-service-provider-config-client start ---------------------");
		SpringApplication.run(ProviderApplication.class,args);
		System.out.println("--------------- micro-service-provider-config-client end ---------------------");
	}
}
