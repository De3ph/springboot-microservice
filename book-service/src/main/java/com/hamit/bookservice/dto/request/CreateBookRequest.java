package com.hamit.bookservice.dto.request;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Author cannot be empty")
    private String author;
    @NotEmpty(message = "ISBN cannot be empty")
    @Length(min = 11, max = 11, message = "ISBN must be 11 characters")
    private String isbn;
    @NotEmpty(message = "Pages cannot be empty")
    private int pages;
    @NotEmpty(message = "PublishedAt cannot be empty")
    private Timestamp publishedAt;
}
