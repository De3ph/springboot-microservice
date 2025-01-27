package com.hamit.bookservice.mapper;

import com.hamit.bookservice.dao.entity.Book;
import com.hamit.bookservice.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookMapperTest {

    @Test
    public void shouldMapBookToBookDto() {

        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Author");
        book.setTitle("Title");


        BookDto dto = BookMapperImpl.INSTANCE.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals(book.getId(), dto.getId());
    }
}