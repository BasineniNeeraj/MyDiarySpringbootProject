package com.neeraj.service;

import com.neeraj.entity.User;

public interface UserService {
	public User saveUser(User user);
	public User findByUname(String uname);
	public User findByPhone(String phone);
}
