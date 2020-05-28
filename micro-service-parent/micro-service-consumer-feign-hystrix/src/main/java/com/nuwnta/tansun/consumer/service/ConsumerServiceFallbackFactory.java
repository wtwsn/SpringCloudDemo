package com.nuwnta.tansun.consumer.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nuwnta.tansun.public0.entity.User;

import feign.hystrix.FallbackFactory;

//hystrix断路器的服务降级机制
@Component
public class ConsumerServiceFallbackFactory implements FallbackFactory<ConsumerService>{

	//当被本项目调用的微服务无法给响应的时候（被调用服务关闭），触发服务降级机制，由调用者返回预设数据。
	@Override
	public ConsumerService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new ConsumerService(){

			@Override
			public User get(int id) {
				// TODO Auto-generated method stub
				System.out.println("get()访问服务失败，触发 断路器 服务降级机制");
				return new User(id,"不存在该用户",-1);
			}

			@Override
			public boolean add(User user) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<User> getAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
	
}
