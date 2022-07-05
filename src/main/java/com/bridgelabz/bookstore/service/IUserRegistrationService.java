package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.LoginDto;
import com.bridgelabz.bookstore.dto.ResetPassword;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;

public interface IUserRegistrationService
{

    ResponseDTO createUser(UserRegistrationDTO userDTO);

    ResponseDTO updateUserById(String token, UserRegistrationDTO userDTO);

    ResponseDTO deleteUserById(String token, int userid);

    ResponseDTO loginUser(LoginDto loginDto);

    ResponseDTO forgotPassword(String email);

    Boolean verify(String token);

    ResponseDTO resetPassword(ResetPassword password, String token);

    int getUserId(String token);

}
