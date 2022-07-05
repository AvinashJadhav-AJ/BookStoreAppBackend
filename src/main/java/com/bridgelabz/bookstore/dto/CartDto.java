package com.bridgelabz.bookstore.dto;

import lombok.Data;

@Data
public class CartDto {
    private Long quantityId;
    private Long quantityOfBook;
    private Double eachPrice;

}