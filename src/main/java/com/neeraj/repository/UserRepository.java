package com.neeraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUname(String uname);
	public User findByPhone(String phone);
}
