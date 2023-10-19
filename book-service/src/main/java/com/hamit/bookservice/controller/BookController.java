package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.entity.Book;
import com.hamit.bookservice.mapper.BookMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping(value = "/books")
public class BookController {

    @GetMapping("/")
    public BookDto getBook() {

        BookDto bookDto = BookMapper.INSTANCE.bookToBookDto(
                Book.builder()
                        .id(UUID.randomUUID())
                        .build());

        return bookDto;
    }
}
