package com.learning.personcrud.controller;

import java.util.List;

import com.learning.personcrud.model.Book;
import com.learning.personcrud.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/new")
    public String createNewBook(@RequestBody(required = true) Book book){
        return bookService.saveBook(book);
    }

    @GetMapping(path = "/all")
    public List<Book> listAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping(path = "/{bookId}")
    public Book getBookById(@PathVariable(
                            name = "bookId",
                            required = true)
                            Long bookId){
        return bookService.findBookById(bookId);
    }

}