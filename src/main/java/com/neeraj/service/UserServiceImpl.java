package com.neeraj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.entity.User;
import com.neeraj.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findByUname(String uname) {
		return userRepository.findByUname(uname);
	}

	@Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
}
