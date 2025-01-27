package com.hamit.bookservice.service.book;

import com.hamit.bookservice.dao.entity.Book;
import com.hamit.bookservice.dao.repository.BookRepository;
import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.exception.BookNotFoundException;
import com.hamit.bookservice.mapper.BookMapper;
import com.hamit.bookservice.service.book.intf.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper mapper = BookMapper.INSTANCE;
    private final BookRepository bookRepository;

    // caches result of method based on id parameter
    // unless condition is true (book is not exist), result will not be cached
    @Cacheable(cacheNames = "book", key = "#id", unless = "#result == null")
    @Override
    public BookDto getBookById(Long id) throws BookNotFoundException {
        Book entity = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return mapper.bookToBookDto(entity);
    }

    @Cacheable(cacheNames = "book")
    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream().map(mapper::bookToBookDto).toList();
    }

    @CachePut(cacheNames = "book", key = "#result.id")
    @Override
    public BookDto createBook(RequestCreateBook request) {
        Book entity = mapper.createRequestToBook(request);
        return mapper.bookToBookDto(bookRepository.save(entity));
    }
}
