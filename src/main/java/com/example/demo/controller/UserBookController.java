package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserBookVw;
import com.example.demo.service.UserBookService;

@RestController
public class UserBookController {

	@Autowired UserBookService userBookService;
	
	
	@GetMapping(path = "/users-books")
	public List<UserBookVw> getAllUserBooks(){
		return userBookService.findAll();
	}
	
	@GetMapping(path = "/users-books/{name}")
	public List<UserBookVw> findByBook(@PathVariable String name){
		return userBookService.findByBookName(name);
	}
}
