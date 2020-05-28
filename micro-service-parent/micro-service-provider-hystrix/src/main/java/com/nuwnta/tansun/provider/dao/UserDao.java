package com.nuwnta.tansun.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nuwnta.tansun.public0.entity.User;

@Mapper
public interface UserDao {
	
	public boolean addUser(User user);
	
	public User getUser(int id);
	
	public List<User> getUsers();
	
}
