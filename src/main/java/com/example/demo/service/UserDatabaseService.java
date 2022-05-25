package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Address;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.UserRepository;

@Component
public class UserDatabaseService implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	public Optional<User> getUser(Long id) {
		System.out.println(userRepository.findById(id).get().getName());
		return userRepository.findById(id);
		
	}
	
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	public User createUser(User user) {
		User savedUser  = userRepository.save(user);
		Address address = new Address();
		address.setCity(user.getAddress().getCity());
		address.setUser(user);
		addressRepository.save(address);		
				
		return savedUser;
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		User dbUser = userRepository.findById(user.getId()).get();
		dbUser.setName(user.getName());
		dbUser.setEmail(user.getEmail());
		
		userRepository.save(dbUser);
		return dbUser;
	}
	
	public void userTeamMapping(Long userId, Long teamId) {
		System.out.println("uid: "+userId);
		System.out.println("tid: "+teamId);
		User user = userRepository.findById(userId).get();
		System.out.println(user.getName());
		Team team = teamRepository.findById(teamId).get();
		System.out.println(team.getName());
		team.addUser(user);
		
		teamRepository.save(team);
		
	}
	
	

}
