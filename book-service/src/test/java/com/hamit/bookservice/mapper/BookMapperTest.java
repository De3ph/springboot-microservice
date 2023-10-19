package com.hamit.bookservice.mapper;

import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookMapperTest {

    @Test
    public void shouldMapBookToBookDto() {

        Book book = Book.builder()
                .id(UUID.randomUUID())
                .title("title")
                .author("author")
                .build();

        BookDto dto = BookMapperImpl.INSTANCE.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals(book.getId(), dto.getId());
    }
}