package com.hamit.bookservice.service.book;

import org.springframework.stereotype.Service;

import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.dto.response.ResponseGetAllBooks;
import com.hamit.bookservice.dto.response.ResponseGetBook;
import com.hamit.bookservice.dao.repository.BookRepository;
import com.hamit.bookservice.service.book.intf.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public ResponseGetBook getBookById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
    }

    @Override
    public ResponseGetAllBooks getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseGetBook createBook(RequestCreateBook request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

}
