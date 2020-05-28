package com.nuwnta.tansun.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
//zuul路由器（网关），所有微服务访问通过此项目实现。
//该项目也会注册到注册中心，注解@EnableZuulProxy中包含着此功能。
public class ZuulApplication {

	public static void main(String[] args) {
		System.out.println("--------------------micro-service-zuul  start----------------------");
		SpringApplication.run(ZuulApplication.class,args);
		System.out.println("--------------------micro-service-zuul  end----------------------");
	}
	
}
