package com.nuwnta.tansun.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {	
	//@EnableEurekaServer是将本工程作为eureka服务端的注册中心来运行。
	public static void main(String[] args) {
		System.out.println("-----------------micro-server-eureka start--------------------");
		SpringApplication.run(EurekaApplication.class, args);
		System.out.println("-----------------micro-server-eureka end--------------------");

	}

}
