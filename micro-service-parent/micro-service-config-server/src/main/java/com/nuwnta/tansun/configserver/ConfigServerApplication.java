package com.nuwnta.tansun.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //配置中心的服务端
public class ConfigServerApplication {

	public static void main(String[] args) {
		System.out.println("---------------micro-service-config-server   start------------------------");
		SpringApplication.run(ConfigServerApplication.class,args);
		System.out.println("---------------micro-service-config-server   end------------------------");
	}

}
