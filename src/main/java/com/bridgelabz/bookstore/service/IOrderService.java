package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.model.Order;

import java.util.List;

public interface IOrderService {


    List<BookModel> placeOrder(String token, List<BookModel> orderBookList);
    public List<Order> orderList(String token);
}