package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.BookModel;

import java.util.List;

public interface IBookService {
    List<BookDTO> getBook();
    BookDTO addBook(BookDTO bookDTO);
    BookDTO getBookByID(int id);
    public List<BookModel> sortPriceLowToHigh();
    public List<BookModel> sortPriceHighToLow();

}