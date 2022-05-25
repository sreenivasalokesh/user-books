package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.exceptiom.BookNotFoundException;
import com.example.demo.service.BookService;

@RestController
public class BooksController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		Optional<Book> book = bookService.getBook(id);
//		if(book.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
		if(book.isEmpty()) {
			throw new RuntimeException("No entry for the selected id");
		}
		return ResponseEntity.ok(book.get());
	}
	
	@GetMapping("/books/")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.getBooks();
		if(books.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(books);
	}
	
	@PostMapping("user/{id}/books/create/")
	public ResponseEntity<Book> createBook(@PathVariable Long id,  @RequestBody Book book) {
		return ResponseEntity.ok(bookService.createBook(id, book));
	}
	
	@PostMapping("/books/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.updateBook(book));
	}
	
	@PostMapping("/books/delete/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/books/updated")
	public List<Book> getUpdatedBooks(){
		return bookService.getUpdatedBooks();
	}
	
	@GetMapping("/books/namedquery/{id}")
	public Book getResultFromANamedQuery(@PathVariable Long id){
		return bookService.getResultFromANamedQuery(id);
	}
}
