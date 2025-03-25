package com.hamit.bookservice.dto;

/*@Getter
@Setter
@AllArgsConstructor
public class BookCoverDto {
    private String title;
    private String author;
    private String isbn;
}

// class kullanmak istersek sadece bir tane constructor tanımlayabiliriz
*/



public record BookCoverDto(String title, String author, String isbn) {}
