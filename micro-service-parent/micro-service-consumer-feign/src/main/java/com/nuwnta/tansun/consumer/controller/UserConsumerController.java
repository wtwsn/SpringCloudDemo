package com.nuwnta.tansun.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuwnta.tansun.consumer.service.ConsumerService;
import com.nuwnta.tansun.public0.entity.User;

@RestController
public class UserConsumerController {

	@Autowired
	private ConsumerService service;
	
	@RequestMapping(value="/consumer/add")
	public boolean addUser(User user){
		Boolean flag = service.add(user);
		return flag;
	}
	
	@RequestMapping(value="/consumer/get/{id}")
	public User get(@PathVariable("id") int id){
		User user = service.get(id);
		return user;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/consumer/list")
	public List<User> getList(){
		List list = service.getAll();
		return list;
	}

}
