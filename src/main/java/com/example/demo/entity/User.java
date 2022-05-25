package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Book> books;
	
	
	@ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<Team> teams = new HashSet<Team>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "clubId.user", cascade = CascadeType.ALL)
	private Set<Club> clubs = new HashSet<Club>();
	

	public User() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Book> getBooks() {
		return books;
	} 

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}


	

}
