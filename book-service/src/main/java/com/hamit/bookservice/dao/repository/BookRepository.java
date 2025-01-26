package com.hamit.bookservice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamit.bookservice.dao.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
