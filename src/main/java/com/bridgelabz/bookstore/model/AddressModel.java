package com.bridgelabz.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String address;
    private String state;
    private String city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id")
    private UserRegistrationModel userRegistrationModel;


}
