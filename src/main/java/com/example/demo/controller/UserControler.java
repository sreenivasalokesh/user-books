package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserControler {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping(path = "/user/create")
	public User createUser(@RequestBody User user) {
		System.out.println("user name: "+user.getName());
		System.out.println("user email: "+user.getEmail());
		return userService.createUser(user);
	}
	
	@GetMapping(path = "/user/{id}")
	public ResponseEntity<User>  getUser(@PathVariable Long id) {
		System.out.println("id: "+id);
		Optional<User> user =  userService.getUser(id);
		if(user.isEmpty()) {
			return ResponseEntity.noContent().build();
			//return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(user.get());
	}
	
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(userService.getUsers());
	}
	
	
	
	@PostMapping(path = "/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@PostMapping(path= "/user/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id); 
	}

	@PostMapping(path = "users/{userId}/teams/{teamId}")
	public ResponseEntity userTeamMapping(@PathVariable Long userId, @PathVariable Long teamId) {
		userService.userTeamMapping(userId, teamId);
		return ResponseEntity.ok().build();
	}
}
