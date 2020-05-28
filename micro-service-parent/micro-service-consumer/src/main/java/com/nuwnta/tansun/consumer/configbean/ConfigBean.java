package com.nuwnta.tansun.consumer.configbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

//类名不能起GetRestTemplate,这样的话spring容器加载RestTemplate的bean时会报重复的bean
@Configuration
public class ConfigBean {

	//@LoadBalanced代表打开负载均衡      //轮询策略  ribbon默认
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	//设置负载均衡策略
	@Bean
	public IRule myRule(){
		return new RoundRobinRule();  //轮询策略  ribbon默认
		//return new RandomRule();  //随机策略
	}
	
	
}
