package com.nuwnta.tansun.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nuwnta.tansun.public0.entity.User;

@RestController
public class UserConsumerController {
	
	//private static String REST_URL_PREFIX = "http://localhost:9020";
	//微服务访问地址写活，直接用 微服务名称。（这就是为什么服务提供者集群的各个项目的名称要保持一致。）
	private static String REST_URL_PREFIX = "http://micro-service-provider";
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="/consumer/add")
	public boolean addUser(User user){
		Boolean flag = restTemplate.postForObject(REST_URL_PREFIX+"/add", user, Boolean.class);
		return flag;
	}
	
	@RequestMapping(value="/consumer/get/{id}")
	public User get(@PathVariable("id") int id){
		User user = restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, User.class);
		return user;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/consumer/list")
	public List<User> getList(){
		List list = restTemplate.getForObject(REST_URL_PREFIX + "/getUser/list", List.class);
		return list;
	}

}
