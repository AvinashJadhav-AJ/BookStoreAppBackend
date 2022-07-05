package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.AddressDTO;
import com.bridgelabz.bookstore.model.AddressModel;

public interface IAddressService {

    AddressModel addAddress(AddressDTO address, String token);
}