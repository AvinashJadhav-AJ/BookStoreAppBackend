package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<AddressModel, Integer> {
}
