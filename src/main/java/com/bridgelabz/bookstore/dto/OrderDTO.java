package com.bridgelabz.bookstore.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderStatus;

    private Double totalPrice;

    private int quantity;


}
