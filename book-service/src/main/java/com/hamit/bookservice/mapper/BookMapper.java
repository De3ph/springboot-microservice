package com.hamit.bookservice.mapper;

import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.CreateBookRequest;
import com.hamit.bookservice.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);
    Book bookDtoToBook(BookDto bookDto);
    Book createRequestToBook(CreateBookRequest request);
}
