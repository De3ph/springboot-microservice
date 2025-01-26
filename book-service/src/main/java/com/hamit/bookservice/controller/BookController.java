package com.hamit.bookservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.dto.response.ResponseGetAllBooks;
import com.hamit.bookservice.dto.response.ResponseGetBook;
import com.hamit.bookservice.service.book.BookServiceImpl;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseGetAllBooks> getAllBooks() {
        return new ResponseEntity<>(bookServiceImpl.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGetBook> getBookById(@PathVariable @NotNull Long id) {
        ResponseGetBook response = bookServiceImpl.getBookById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseGetBook> createBook(@RequestBody RequestCreateBook request) {
        return new ResponseEntity<>(bookServiceImpl.createBook(request), HttpStatus.OK);
    }

}
