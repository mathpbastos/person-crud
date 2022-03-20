package com.learning.personcrud.service;

import com.learning.personcrud.model.Book;

import java.util.Collection;

public interface BookService {

    Book createBook(Book book);
    Collection<Book> listAllBooks(int limit);
    Book getBook(Long id);
    //Book updateBook(Book book);
    Boolean deleteBookById(Long id);

}
