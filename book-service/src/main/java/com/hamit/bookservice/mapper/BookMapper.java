package com.hamit.bookservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hamit.bookservice.dao.entity.Book;
import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.RequestCreateBook;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    Book createRequestToBook(RequestCreateBook request);
}
