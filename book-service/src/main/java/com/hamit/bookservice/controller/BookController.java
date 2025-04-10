package com.hamit.bookservice.controller;

import com.hamit.bookservice.dto.BookCoverDto;
import com.hamit.bookservice.dto.BookDto;
import com.hamit.bookservice.dto.request.RequestCreateBook;
import com.hamit.bookservice.dto.response.ResponseGetAllBooks;
import com.hamit.bookservice.dto.response.ResponseGetBook;
import com.hamit.bookservice.service.book.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
@Validated
@Tag(name = "Book Controller", description = "Book management API")
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @Operation(summary = "Get all books", description = "Retrieves a list of all books")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all books", 
            content = @Content(schema = @Schema(implementation = ResponseGetAllBooks.class)))
    })
    @GetMapping
    public ResponseEntity<ResponseGetAllBooks> getAllBooks() {
        List<BookDto> dtos = bookServiceImpl.getAll();
        return new ResponseEntity<>(new ResponseGetAllBooks(dtos), HttpStatus.OK);
    }

    @Operation(summary = "Get a book by ID", description = "Retrieves a book by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Book found", 
            content = @Content(schema = @Schema(implementation = ResponseGetBook.class))),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseGetBook> getBookById(@PathVariable @NotNull Long id) {
        BookDto dto = bookServiceImpl.getBookById(id);
        return new ResponseEntity<>(new ResponseGetBook(dto), HttpStatus.OK);
    }

    @Operation(summary = "Get book cover by ID", description = "Retrieves a book cover by book ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Book cover found", 
            content = @Content(schema = @Schema(implementation = BookCoverDto.class))),
        @ApiResponse(responseCode = "404", description = "Book cover not found")
    })
    @GetMapping("/cover/{id}")
    public ResponseEntity<BookCoverDto> getBookCoverById(@PathVariable @NotNull Long id) {
        BookCoverDto coverDto = bookServiceImpl.getBookCoverById(id);
        return new ResponseEntity<>(coverDto, HttpStatus.OK);
    }

    @Operation(summary = "Create a new book", description = "Creates a new book entry")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Book created successfully", 
            content = @Content(schema = @Schema(implementation = ResponseGetBook.class)))
    })
    @PostMapping
    public ResponseEntity<ResponseGetBook> createBook(@RequestBody RequestCreateBook request) {
        BookDto dto = bookServiceImpl.createBook(request);
        return new ResponseEntity<>(new ResponseGetBook(dto), HttpStatus.CREATED);
    }

}
