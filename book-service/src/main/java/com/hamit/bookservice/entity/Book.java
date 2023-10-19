package com.hamit.bookservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    @Id
    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private int pages;
    private Timestamp publishedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
