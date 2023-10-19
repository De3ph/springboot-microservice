package com.hamit.bookservice.dto.response;

import com.hamit.bookservice.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllBooksResponse {
    List<GetBookResponse> books;
}
