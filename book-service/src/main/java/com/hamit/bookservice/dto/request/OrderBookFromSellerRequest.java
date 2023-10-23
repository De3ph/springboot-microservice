package com.hamit.bookservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderBookFromSellerRequest {
    private String bookTitle;
    private String publisher;
    private String author;
    private int price;
    private int amount;
}
