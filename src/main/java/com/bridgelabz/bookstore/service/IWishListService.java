package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.BookModel;

import java.util.List;

public interface IWishListService {
    String addBooktoWishlist(String token, int bookId);

    List<BookModel> findBookList(String token);

    String deleteBookFromWishList(String token, int bookId);

}