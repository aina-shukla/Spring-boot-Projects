package com.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;
import com.demo.services.BookService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TestService {
    
    @Autowired
    private BookService service;

    @MockBean
    private BookRepository repo;


    @Test
    public void shouldGetAllBooks(){

        Mockito
            .when(repo.findAll())
            .thenReturn(Arrays.asList(
                new Book(5.5, "java book", "Mark"),
                new Book(2.5, "html book", "Carl")
             ));

        List<Book> books = service.findBooksFromDb();

        System.out.println("++++++++++++++++"+LocalDateTime.now());
        System.out.println("++++++++++++++++"+LocalDateTime.now());
        System.out.println("++++++++++++++++"+LocalDateTime.now());
        System.out.println("++++++++++++++++"+LocalDateTime.now());
        System.out.println(books);

        Assertions.assertTrue(books.size()>0);
    }

}