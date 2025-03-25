package com.hamit.bookservice.dao.repository;

import com.hamit.bookservice.dao.entity.Book;
import com.hamit.bookservice.dto.BookCoverDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    BookCoverDto findBookCoverDtoById(Long id);
}
