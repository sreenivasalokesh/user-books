package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.UserBookVw;

public interface UserBookRepository extends ReadOnlyRepository<UserBookVw, Long>{
	
	public List<UserBookVw> findByBookName(String name);

}
