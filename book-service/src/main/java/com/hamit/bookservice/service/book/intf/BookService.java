package com.hamit.bookservice.service.book.intf;

import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.exception.BookNotFoundException;

import java.util.List;

public interface BookService {
    BookDto getBookById(Long id) throws BookNotFoundException;

    List<BookDto> getAll();

    BookDto createBook(RequestCreateBook request);

}
