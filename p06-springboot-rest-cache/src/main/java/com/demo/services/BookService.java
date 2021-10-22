package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Cacheable(value="books")
	public List<Book> findBooksFromDb(){
		
		System.out.println("In service: Finding all books");
		System.out.println(System.currentTimeMillis());
		
//		return Arrays.asList(new Book(50, "Dance with me", "Miley"));
		return bookRepository.findAll();
	}

	public Book create(Book b) {
		// logic to validate
		return bookRepository.save(b);
	}

	@Cacheable(key="#id", value="book")
	public Book findBook(int id) {
		System.out.println("Finding book from database where id is "+id);
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isEmpty()) {			
			// raise exception
			return null;
		} else {
			return optional.get();
		}
	}

	@CachePut(value="book", key="#id")
	public Book updateBook(int id, Book b) {
		if(bookRepository.existsById(id)) {	
			b.setId(id);
			return bookRepository.save(b);
		} else {
			System.out.println("Given id is not available");
			return null;
		}
		
	}
	
//	@CacheEvict(key="#id", value="book")
	
}
