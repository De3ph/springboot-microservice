package com.hamit.bookservice.service;

import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.dto.response.GetAllBooksResponse;
import com.hamit.bookservice.dto.response.GetBookResponse;
import com.hamit.bookservice.entity.Book;
import com.hamit.bookservice.feign.OrderClient;
import com.hamit.bookservice.mapper.BookMapper;
import com.hamit.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    private final OrderClient orderClient;

    public BookService(BookRepository bookRepository, OrderClient orderClient) {
        this.bookRepository = bookRepository;
        this.orderClient = orderClient;
    }

    @Override
    public GetBookResponse getBookById(Long id) {
        GetBookResponse response = new GetBookResponse();
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            response.setBookDto(BookMapper.INSTANCE.bookToBookDto(book));
        }

        return response;
    }

    @Override
    public GetAllBooksResponse getAll() {
        GetAllBooksResponse response = new GetAllBooksResponse();
        List<GetBookResponse> dtos = new ArrayList<>();

        bookRepository.findAll().forEach(book -> {
            GetBookResponse dto = new GetBookResponse();
            dto.setBookDto(BookMapper.INSTANCE.bookToBookDto(book));
            dtos.add(dto);
        });

        response.setBooks(dtos);

        return response;
    }

    @Override
    public GetBookResponse createBook(CreateBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        Book book = BookMapper.INSTANCE.createRequestToBook(request);
        BookDto dto = BookMapper.INSTANCE.bookToBookDto(bookRepository.save(book));
        response.setBookDto(dto);

        return response;
    }

    public String orderBookFromSeller() {
        return orderClient.getBookName();
    }
}
