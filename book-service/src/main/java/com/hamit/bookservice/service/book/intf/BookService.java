package com.hamit.bookservice.service.book.intf;

import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.dto.response.ResponseGetAllBooks;
import com.hamit.bookservice.dto.response.ResponseGetBook;

public interface BookService {
    ResponseGetBook getBookById(Long id);

    ResponseGetAllBooks getAll();

    ResponseGetBook createBook(RequestCreateBook request);

}
