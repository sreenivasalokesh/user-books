package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="user_team_map", joinColumns = @JoinColumn (name = "team_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
	@JsonIgnore
	Set<User> users = new HashSet<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("users")
	public Set<User> getParentUsers() {
		Set<User> result = new HashSet<User>();
		for (User user : users) {
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setEmail(user.getEmail());
			newUser.setName(user.getName());
			newUser.setBooks(user.getBooks());		
			result.add(newUser);
		}
		return result;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	
	
}
