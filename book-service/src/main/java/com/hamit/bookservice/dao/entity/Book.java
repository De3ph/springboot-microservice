package com.hamit.bookservice.dao.entity;

import com.hamit.bookservice.dao.entity.base.CoreEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends CoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PUBLISHER")
    private String publisher;
    @Column(name = "ISBN",unique = true)
    private String isbn;
    @Column(name = "PAGES")
    private Integer pages;
    @Column(name = "PUBLISHED_AT")
    private LocalDateTime publishedAt;

}
