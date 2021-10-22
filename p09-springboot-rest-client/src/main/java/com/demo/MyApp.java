package com.demo;

import java.util.List;

import com.demo.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MyApp implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// System.out.println(getAllBooks());
		int id = 5;
		System.out.println(getBook(id));
		// { id='5', price='98.8', title='Great book', author='Mark Carl'}
//		System.out.println(saveBook(new Book(123.456, "123456", "hero")));
	}

	private Book saveBook(Book book){
		System.out.println("Saving book in db");

		String serverUrl = "http://localhost:8080/books";
		HttpMethod methodType = HttpMethod.POST;
		HttpEntity<Book> requestBody = new HttpEntity<Book>(book);
		ParameterizedTypeReference<Book> responseType = new ParameterizedTypeReference<Book>(){};

		ResponseEntity<Book> responseEntity =  restTemplate.exchange(serverUrl, methodType, requestBody, responseType);

		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.hasBody());


		return responseEntity.getBody();
	}


	
	private Book getBook(int id){
		System.out.println("Finding book from app 03 with id "+id);

		String serverUrl = "http://localhost:8080/books/"+id;
		HttpMethod methodType = HttpMethod.GET;
		HttpEntity<Object> requestBody = null;
		ParameterizedTypeReference<Book> responseType = new ParameterizedTypeReference<Book>(){};

		ResponseEntity<Book> responseEntity =  restTemplate.exchange(serverUrl, methodType, requestBody, responseType);

		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.hasBody());


		return responseEntity.getBody();
	}

	private List<Book> getAllBooks(){
		System.out.println("Finding all books from app 03");

		String serverUrl = "http://localhost:8080/books";
		HttpMethod methodType = HttpMethod.GET;
		HttpEntity<Object> requestBody = null;
		ParameterizedTypeReference<List<Book>> responseType = new ParameterizedTypeReference<List<Book>>(){};

		ResponseEntity<List<Book>> responseEntity =  restTemplate.exchange(serverUrl, methodType, requestBody, responseType);

		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.hasBody());


		return responseEntity.getBody();
	}

}
