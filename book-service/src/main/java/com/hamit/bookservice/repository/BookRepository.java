package com.hamit.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hamit.bookservice.entity.Book;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
