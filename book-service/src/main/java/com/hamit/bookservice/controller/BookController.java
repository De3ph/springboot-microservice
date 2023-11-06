package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.dto.request.GetBookByIdRequest;
import com.hamit.bookservice.dto.response.GetAllBooksResponse;
import com.hamit.bookservice.dto.response.GetBookResponse;
import com.hamit.bookservice.service.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/books")
@Validated
public class BookController implements IBookController {

    private final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        return new ResponseEntity<>(bookServiceImpl.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping("/book")
    public ResponseEntity<GetBookResponse> getBookById(@RequestBody GetBookByIdRequest request) {
        GetBookResponse response = bookServiceImpl.getBookById(request.getId());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<GetBookResponse> createBook(@RequestBody CreateBookRequest request) {
        return new ResponseEntity<>(bookServiceImpl.createBook(request), HttpStatus.OK);
    }

//    @GetMapping("/order")
//    public String orderBookFromSeller() {
//        return bookServiceImpl.orderBookFromSeller();
//    }
}
