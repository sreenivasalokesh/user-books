package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UserBookVw;
import com.example.demo.repository.UserBookRepository;


@Component
public class UserDatabaseBookService implements UserBookService{
	
	@Autowired UserBookRepository userBookRepos;

	@Override
	public List<UserBookVw> findAll() {
		System.out.println("count: "+ userBookRepos.findAll().size());
		return userBookRepos.findAll();
	}
	
	@Override
	public List<UserBookVw> findByBookName(String name) {
		System.out.println("count: "+ userBookRepos.findByBookName(name).size());
		return userBookRepos.findByBookName(name);
	}

}
