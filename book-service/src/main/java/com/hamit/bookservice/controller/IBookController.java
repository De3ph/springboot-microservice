package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.dto.request.GetBookByIdRequest;
import com.hamit.bookservice.dto.response.GetAllBooksResponse;
import com.hamit.bookservice.dto.response.GetBookResponse;
import org.springframework.http.ResponseEntity;

public interface IBookController {
    ResponseEntity<GetAllBooksResponse> getAllBooks();
    ResponseEntity<GetBookResponse> getBookById(GetBookByIdRequest request);
    ResponseEntity<GetBookResponse> createBook(CreateBookRequest request);
}
