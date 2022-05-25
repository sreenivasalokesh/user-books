package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "USERS_BOOKS_VW")
public class UserBookVw {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "book_name") 
	private String bookName;

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getBookName() {
		return bookName;
	}

	
}
