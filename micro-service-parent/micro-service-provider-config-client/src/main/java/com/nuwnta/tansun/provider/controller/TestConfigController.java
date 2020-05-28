package com.nuwnta.tansun.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //刷新配置，取最新的配置。 哪个类在读取配置文件中的数据，哪个类就加上此注解
public class TestConfigController {

	//如果没有获取到env.name 的值，就会默认读取 :后面的值，相当于一个默认值
	@Value("${env.name:config server not found}")
	private String envName;
	
	@RequestMapping(value="/testconf")
	public String testConf(){
		return "Hello "+envName;
	}
	
}
