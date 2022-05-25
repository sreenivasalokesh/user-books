package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "Book.findByIdNamedQuery", query="SELECT b FROM Book b WHERE b.id=?1")
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@Column
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "user_id")
	private User user;
	
	
	//Not using JsonIgnore will cause recursive loop as user fetch books and books fetch users
	@JsonIgnore
	public User getUser() {
		return user;
	}

	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}
	
	
	//Methods to get parent class data
	public Long getUserId() {
		return user!=null ? user.getId(): null; 
	}
	
	public String getUserName() {
		return user!=null ?  user.getName() : null;
	}

	public Book() {
	}

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


	
	
}
