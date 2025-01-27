package com.hamit.bookservice.dto.response;

import java.util.List;

import com.hamit.bookservice.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponseGetAllBooks {
    List<BookDto> books;
}
