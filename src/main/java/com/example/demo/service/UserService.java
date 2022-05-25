package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {
	
	public Optional<User> getUser(Long id);
	
	public List<User> getUsers();
		
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(Long id);
	
	public void userTeamMapping(Long userId, Long teamId);

}
