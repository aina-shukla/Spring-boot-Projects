package com.demo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isEmpty()) {			
			// raise exception
			return null;
		} else {
			return optional.get();
		}
	}
	
}
