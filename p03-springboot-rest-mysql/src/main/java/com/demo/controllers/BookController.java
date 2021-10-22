package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Book;
import com.demo.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks(){
		System.out.println("Finding all books");
		return bookService.findBooksFromDb();
	}
	@GetMapping("/books/{id}")
	public Book getBooks(@PathVariable int id){
		System.out.println("Finding book by id: "+id);
		return bookService.findBook(id);
	}
	@PostMapping("/books")
	public Book save(@RequestBody Book b){
		System.out.println("Finding all books");
		return bookService.create(b);
	}
	
}
