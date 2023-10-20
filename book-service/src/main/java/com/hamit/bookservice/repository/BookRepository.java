package com.hamit.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hamit.bookservice.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
