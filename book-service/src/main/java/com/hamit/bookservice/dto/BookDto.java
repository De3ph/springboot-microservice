package com.hamit.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private int pages;
    private Timestamp publishedAt;
}
