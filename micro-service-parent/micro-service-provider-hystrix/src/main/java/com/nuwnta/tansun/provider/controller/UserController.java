package com.nuwnta.tansun.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nuwnta.tansun.provider.service.UserService;
import com.nuwnta.tansun.public0.entity.User;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public boolean addUser(@RequestBody User user){
		boolean flag = service.addUser(user);
		return flag;
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	//采用hytrix断路器的熔断机制。一旦服务调用失败，就调用hystrixGetUser方法。
	//@HystrixCommand注解要配合在启动类上加@EnableCircuitBreaker注解.
	@HystrixCommand(fallbackMethod="hystrixGetUser")
	public User getUser(@PathVariable("id") int id){
		User user = service.getUser(id);
		//如果不加这层if，会返回一个null对象，前端显示空白，无报错。
		if(user == null){
			throw new RuntimeException("不存在id=" + id + "对应的用户信息");
		}
		System.out.println("调用服务提供者provider9020，获取user："+user);
		return user;
	}
	
	@RequestMapping(value="/getUser/list", method=RequestMethod.GET)
	public List<User> getUsers(){
		List<User> users = service.getUsers();
		return users;
	}
	
	//getUser方法异常触发hystrix服务熔断机制时返回的一笔预设数据
	public User hystrixGetUser(@PathVariable("id") int id){
		User user = new User(id,"不存在该用户",0);
		System.out.println("getUser触发服务提供者provider9020的hystrix熔断机制返回预设数据");
		return user;
	}
	
	// 临时的测试方法   故意使项目抛出异常
	// 验证 ：  当服务消费者加有断路器的服务降级机制时，服务提供者报异常时，能否触发消费者端的服务降级机制???
	// 答案: 可以。
	// 结论： hystrix断路器的容错机制中,熔断机制 是在服务提供者端（本项目）处理数据异常时提供预设数据进行容错，避免抛出异常导致消费者调用失败。
	//                         服务降级机制，是在服务消费者端调用服务提供者失败后（服务提供者因关闭而访问不到或处理时异常），提供预设数据进行容错。
	//     上述两种hystrix容错机制面向的步骤层级不同。
	@RequestMapping(value="/get0/{id}", method=RequestMethod.GET)
	public User get0User(@PathVariable("id") int id){
		User user = service.getUser(id);
		//如果不加这层if，会返回一个null对象，前端显示空白，无报错。
		if(user == null){
			throw new RuntimeException("不存在id=" + id + "对应的用户信息");
		}
		System.out.println("调用服务提供者provider9020，get0获取user："+user);
		return user;
	}

}
