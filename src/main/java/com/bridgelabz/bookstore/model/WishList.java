package com.bridgelabz.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="wishbook")
public class WishList {
    @Id
    @GeneratedValue
    private int cartId;

    @OneToOne()
    @JoinColumn(name = "bookId")
    private BookModel bookModel;

    @OneToOne()
    @JoinColumn(name = "Id")
    private UserRegistrationModel userRegistrationModel;

    private LocalDateTime createdTime;
}