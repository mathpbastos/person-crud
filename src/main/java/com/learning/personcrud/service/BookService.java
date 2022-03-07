package com.learning.personcrud.service;

import java.util.List;

import com.learning.personcrud.model.Book;
import com.learning.personcrud.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
 
    @Autowired
    private BookRepository bookRepository;

    public String saveBook(Book book){
        bookRepository.save(book);
        return "Book saved successfully!";
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(() ->
            new IllegalStateException("Book with id " + bookId + "not found."));
    }

}
