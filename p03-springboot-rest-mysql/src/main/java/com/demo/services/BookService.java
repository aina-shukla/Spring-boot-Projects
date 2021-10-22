package com.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findBooksFromDb(){
//		return Arrays.asList(new Book(50, "Dance with me", "Miley"));
		return bookRepository.findAll();
	}

	public Book create(Book b) {
		// logic to validate
		return bookRepository.save(b);
	}

	public Book findBook(int id) {
		return bookRepository.findById(id).orElse(null);
	}
	
}
