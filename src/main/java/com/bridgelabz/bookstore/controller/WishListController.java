package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.service.IWishListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "",allowedHeaders = "")
public class WishListController {

    @Autowired
    private IWishListService WishListService;

    /**
     *
     *
     * @param token
     * @param bookId
     * @return
     */

    @GetMapping("/addbookWishlist/{bookId}")
    public ResponseEntity<ResponseDTO> addBooktoWishlist(@RequestHeader("token") String token, @PathVariable int bookId) {
        String message = WishListService.addBooktoWishlist(token,bookId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO("book added to Wishlist", message));

    }

    /**
     *
     * @param token
     * @return
     */
    @GetMapping("/getWishlistofUser/{token}")
    public List<BookModel> getCartBookList(@PathVariable String token){
        return WishListService.findBookList(token);
    }

    /**
     *
     * @param token
     * @param bookId
     * @return
     */
    @GetMapping("/deleteBookFromWishList/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookFromCart(@RequestHeader("token") String token,@PathVariable int bookId) {
        String message = WishListService.deleteBookFromWishList(token,bookId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO("Book is deleted from Wishlist", message));
    }
}