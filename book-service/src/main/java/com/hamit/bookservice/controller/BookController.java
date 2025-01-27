package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.dto.response.ResponseGetAllBooks;
import com.hamit.bookservice.dto.response.ResponseGetBook;
import com.hamit.bookservice.service.book.BookServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseGetAllBooks> getAllBooks() {
        List<BookDto> dtos = bookServiceImpl.getAll();
        return new ResponseEntity<>(new ResponseGetAllBooks(dtos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGetBook> getBookById(@PathVariable @NotNull Long id) {
        BookDto dto = bookServiceImpl.getBookById(id);
        return new ResponseEntity<>(new ResponseGetBook(dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseGetBook> createBook(@RequestBody RequestCreateBook request) {
        BookDto dto = bookServiceImpl.createBook(request);
        return new ResponseEntity<>(new ResponseGetBook(dto), HttpStatus.CREATED);
    }

}
