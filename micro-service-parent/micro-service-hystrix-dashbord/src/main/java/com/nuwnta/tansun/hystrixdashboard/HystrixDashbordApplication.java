package com.nuwnta.tansun.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//Hystrix的服务监控项目: 监控服务提供者的请求数量、熔断数量、健康状况等。
//创建该项目三步:1.pom引入依赖 2.yml配置文件设置端口 3.启动类加@EnableHystrixboard注解
//访问地址:  项目部署地址:端口号/hystrix
public class HystrixDashbordApplication {

	public static void main(String[] args) {
		System.out.println("-----------------micro-service-hystrix-dashboard  start----------------------");
		SpringApplication.run(HystrixDashbordApplication.class,args);
		System.out.println("-----------------micro-service-hystrix-dashboard  end----------------------");
	}

}
