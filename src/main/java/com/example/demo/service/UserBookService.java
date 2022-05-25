package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserBookVw;

public interface UserBookService {
	public List<UserBookVw>findAll();
	public List<UserBookVw> findByBookName(String name);
}
