package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.dto.request.GetBookByIdRequest;
import com.hamit.bookservice.dto.response.GetAllBooksResponse;
import com.hamit.bookservice.dto.response.GetBookResponse;

public interface IBookController {
    GetAllBooksResponse getAllBooks();
    GetBookResponse getBookById(GetBookByIdRequest request);
    GetBookResponse createBook(CreateBookRequest request);
}
