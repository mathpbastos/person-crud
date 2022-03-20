package com.learning.personcrud.service.implementation;

import java.util.Collection;
import java.util.List;

import com.learning.personcrud.model.Book;
import com.learning.personcrud.repository.BookRepository;

import com.learning.personcrud.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        log.info("Saving new book: {}");
        return bookRepository.save(book);
    }

    @Override
    public Collection<Book> listAllBooks(int limit) {
        log.info("Getting all books...");
        return bookRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Book getBook(Long bookId) {
        log.info("Getting book with ID: {}");
        return bookRepository.findById(bookId).get();
    }

    @Override
    public Boolean deleteBookById(Long bookId) {
        log.info("Deleting book with ID: {}");
        bookRepository.deleteById(bookId);
        return Boolean.TRUE;
    }
}
