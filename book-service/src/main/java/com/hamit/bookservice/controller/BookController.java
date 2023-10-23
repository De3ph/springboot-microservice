package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.dto.request.GetBookByIdRequest;
import com.hamit.bookservice.dto.response.GetAllBooksResponse;
import com.hamit.bookservice.dto.response.GetBookResponse;
import com.hamit.bookservice.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/books")
@Validated
public class BookController implements IBookController{

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @GetMapping("/")
    public GetAllBooksResponse getAllBooks() {
        return bookService.getAll();
    }

    @Override
    @PostMapping("/book")
    public GetBookResponse getBookById(@RequestBody GetBookByIdRequest request) {
        GetBookResponse response = bookService.getBookById(request.getId());
        return response;
    }

    @Override
    @PostMapping("/create")
    public GetBookResponse createBook(@RequestBody CreateBookRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping("/order")
    public String orderBookFromSeller() {
        return bookService.orderBookFromSeller();
    }
}
