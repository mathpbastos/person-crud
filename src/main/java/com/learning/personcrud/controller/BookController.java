package com.learning.personcrud.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.learning.personcrud.model.Book;
import com.learning.personcrud.model.Response;
import com.learning.personcrud.service.implementation.BookServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @PostMapping("/save")
    public ResponseEntity<Response> createNewBook(@RequestBody @Valid Book book){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Book", bookService.createBook(book)))
                        .message("Book Saved")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listAllBooks(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Books", bookService.listAllBooks(30)))
                        .message("Books retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/get/{bookId}")
    public ResponseEntity<Response> getBookById(@PathVariable("bookId") Long bookId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Book", bookService.getBook(bookId)))
                        .message("Book retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Response> deleteBook(@PathVariable("bookId") Long bookId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Deleted", bookService.deleteBookById(bookId)))
                        .message("Book deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}