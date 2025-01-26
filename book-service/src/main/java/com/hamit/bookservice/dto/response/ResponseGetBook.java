package com.hamit.bookservice.dto.response;

import com.hamit.bookservice.dto.BookDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseGetBook {
    BookDto dto;
}
