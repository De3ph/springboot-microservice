package com.hamit.bookservice.service;

import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.dto.response.GetAllBooksResponse;
import com.hamit.bookservice.dto.response.GetBookResponse;

public interface IBookService {
    GetBookResponse getBookById(Long id);
    GetAllBooksResponse getAll();
    GetBookResponse createBook(CreateBookRequest request);

//    OrderBookFromSellerResponse orderBookFromSeller(OrderBookFromSellerRequest request);
}
