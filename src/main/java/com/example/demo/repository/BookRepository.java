package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT u FROM Book u WHERE u.name like '%pdated%'")
	public List<Book> getUpdatedBooks();
	
	public Book findByIdNamedQuery(Long id);

}
