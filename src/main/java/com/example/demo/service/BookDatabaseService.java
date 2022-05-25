package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

@Component
public class BookDatabaseService implements BookService {
	
	@Autowired BookRepository bookRepository;
	@Autowired UserRepository userRepository;

	@Override
	public Optional<Book> getBook(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book createBook(Long userId, Book book) {
		System.out.println("service userId: "+userId);
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new Error("User not found");
			
		}
		book.setUser(user.get());
		return bookRepository.save(book);
		
	}

	@Override
	public Book updateBook(Book book) {
		Long id = book.getId();
		Book dbBook = (bookRepository.findById(id)).get();
		dbBook.setName(book.getName());
		return bookRepository.save(dbBook);
	}

	@Override
	public void deleteBook(Long id) {		
		bookRepository.deleteById(id);
	}
	
	public List<Book> getUpdatedBooks(){
		return bookRepository.getUpdatedBooks();
	}
	
	@Override
	public Book getResultFromANamedQuery(Long id) {
		return bookRepository.findByIdNamedQuery(id);
	}

}
