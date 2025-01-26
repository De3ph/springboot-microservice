package com.hamit.bookservice.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hamit.bookservice.dao.entity.Book;
import com.hamit.bookservice.dto.BookDto;

@SpringBootTest
class BookMapperTest {

    @Test
    public void shouldMapBookToBookDto() {

        Book book = Book.builder()
                .id(1L)
                .title("title")
                .author("author")
                .build();

        BookDto dto = BookMapperImpl.INSTANCE.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals(book.getId(), dto.getId());
    }
}