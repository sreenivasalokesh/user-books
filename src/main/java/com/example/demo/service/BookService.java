package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;

@Component
public interface BookService {

	public Optional<Book> getBook(Long id);
	public List<Book> getBooks();
	public Book createBook(Long userId, Book book);
	public Book updateBook(Book book);
	public void deleteBook(Long id);
	
	public List<Book> getUpdatedBooks();
	public Book getResultFromANamedQuery(Long id);
}
