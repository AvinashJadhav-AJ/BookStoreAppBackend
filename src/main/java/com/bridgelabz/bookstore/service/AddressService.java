package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.AddressDTO;
import com.bridgelabz.bookstore.model.AddressModel;
import com.bridgelabz.bookstore.model.UserRegistrationModel;
import com.bridgelabz.bookstore.repository.AddressRepository;
import com.bridgelabz.bookstore.repository.BookRepository;
import com.bridgelabz.bookstore.repository.UserRegistrationRepository;
import com.bridgelabz.bookstore.util.TokenUtil;
import com.bridgelabz.bookstore.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService{

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRegistrationRepository userRepository;

    @Autowired
    BookRepository bookStoreRepository;


    /**
     *
     * @param address
     * @param token
     * @return
     */
    @Override
    public AddressModel addAddress(AddressDTO address, String token) {
        int userId = TokenUtil.decodeToken(token);
        UserRegistrationModel user = userRepository.findById(userId).orElse(null);
        AddressModel addressDetails=new AddressModel();
        addressDetails.setAddress(address.getAddress());
        addressDetails.setCity(address.getCity());
        addressDetails.setState(address.getState());
//        addressDetails.setType(address.getType());
        addressDetails.setUserRegistrationModel(user);
        return addressRepository.save(addressDetails);
    }
}