package com.nuwnta.tansun.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuwnta.tansun.public0.entity.User;

/*以后调用micro-service-provider微服务中的方法，只需要调用下面对应的接口既可以了*/
//@FeignClient的fallbackFactory属性是指定服务降级机制的容错处理工厂类（自定义如何处理）
@FeignClient(value="micro-service-provider",fallbackFactory=ConsumerServiceFallbackFactory.class)
public interface ConsumerService {

	// hystrix断路器的容错机制中,熔断机制 是在服务提供者端处理数据异常时提供预设数据进行容错，避免抛出异常导致消费者调用失败。
	//                     服务降级机制，是在服务消费者(本项目)端调用服务提供者失败后（服务提供者因关闭而访问不到或处理时异常），提供预设数据进行容错。
	// 上述两种hystrix容错机制面向的步骤层级不同。
	//测试用的方法
	//@RequestMapping(value="/get0/{id}",method=RequestMethod.GET)
	//public User get(@PathVariable("id") int id);
	
	
	/*调用接口中的get方法，即可以向micro-service-provider微服务发送/get/{id}请求*/
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public User get(@PathVariable("id") int id);
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public boolean add(User user);
	
	@RequestMapping(value="/getUser/list",method=RequestMethod.GET)
	public List<User> getAll();
	
}
