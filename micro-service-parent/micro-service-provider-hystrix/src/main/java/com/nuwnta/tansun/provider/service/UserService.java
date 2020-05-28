package com.nuwnta.tansun.provider.service;

import java.util.List;

import com.nuwnta.tansun.public0.entity.User;

public interface UserService {
		
	public boolean addUser(User user);
	
	public User getUser(int id);
	
	public List<User> getUsers();
	
}
