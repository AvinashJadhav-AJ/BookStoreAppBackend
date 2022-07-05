package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.AddressDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.AddressModel;
import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.model.Order;
import com.bridgelabz.bookstore.service.IAddressService;
import com.bridgelabz.bookstore.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
@CrossOrigin(origins = "",allowedHeaders = "")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IAddressService addressService;

//        @PostMapping("/placeOrder/{token}")
//        public ResponseEntity<ResponseDTO> AddUserAddress(@RequestBody OrderDTO orderDTO, @PathVariable String token) {
//            List<BookModel> orderData = orderService.placeOrder(orderDTO, token);
//            ResponseDTO resDTO = new ResponseDTO("Order Placed Successfully ",orderData);
//            return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
//        }

    /**
     *
     * @param orderBookList
     * @param token
     * @return
     */
    @PostMapping("/placeOrder/{token}")
    public ResponseEntity<ResponseDTO> AddUserBookList(@RequestBody List<BookModel> orderBookList,
                                                       @PathVariable String token) {
        List<BookModel> orderData = orderService.placeOrder(token,orderBookList);
        ResponseDTO resDTO = new ResponseDTO("Order Placed Successfully ",orderData);
        return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
    }

    /**
     *
     * @param addressDTO
     * @param token
     * @return
     */
    @PostMapping("/addAddress/{token}")
    public ResponseEntity<ResponseDTO> AddUserAddress(@RequestBody AddressDTO addressDTO,
                                                      @PathVariable String token) {
        AddressModel orderData = addressService.addAddress(addressDTO,token);
        ResponseDTO resDTO = new ResponseDTO("Address Added Successfully ");
        return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
    }

    /**
     *
     * @param token
     * @return
     */
    @GetMapping("/orderList/{token}")
    public ResponseEntity<ResponseDTO> getUserOrderList(@PathVariable String token){
        List<Order> orderList = orderService.orderList(token);
        ResponseDTO resDto= new ResponseDTO("Order List Displayed", orderList);
        return new ResponseEntity<ResponseDTO>(resDto,HttpStatus.OK);
    }

}
