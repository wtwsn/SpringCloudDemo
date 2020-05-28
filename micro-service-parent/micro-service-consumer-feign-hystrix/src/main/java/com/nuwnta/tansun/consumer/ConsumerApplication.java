package com.nuwnta.tansun.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.nuwnta.tansun.consumer.service")
//@EnableEurekaClient使消费者与注册中心联系起来，可以拉取微服务列表。
//@EnableFeignClients注解扫描带@FeignClient的类，如果不指定basePackages，默认是会扫描本注解所在包的当前包及子包。
//                    使消费者项目启动时加载一些必须的bean，如RestTemplate(个人理解)。
//                    注意:指定basePackages时，是指定路径到包，不是到类。

public class ConsumerApplication {
	
	public static void main(String[] args) {
		System.out.println("----------------micro-service-consumer-feign-hystrix  start---------------------------");
		SpringApplication.run(ConsumerApplication.class,args);
		System.out.println("----------------micro-service-consumer-feign-hystrix  end---------------------------");
	}
	
}
