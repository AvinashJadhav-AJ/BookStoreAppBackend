package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.BookModel;
import com.bridgelabz.bookstore.model.CartItem;
import com.bridgelabz.bookstore.model.UserRegistrationModel;
import com.bridgelabz.bookstore.repository.BookRepository;
import com.bridgelabz.bookstore.repository.CartRepository;
import com.bridgelabz.bookstore.repository.UserRegistrationRepository;
import com.bridgelabz.bookstore.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private UserRegistrationRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartRepository cartRepository;

    /**
     *
     * @param token
     * @param bookId
     * @return
     */
    @Override
    public String addBooktoCart(String token, int bookId) {

        int userId = TokenUtil.decodeToken(token);

        UserRegistrationModel user = userRepository.findById(userId).orElse(null);

        BookModel book = bookRepository.findById(bookId).orElse(null);

        // if the book present in wishlist and book number is not equal to zero
        int noOfBooks = book.getNoOfBooks();

        if (noOfBooks > 0) {
            List<BookModel> books = findBookList(token);
            if (books == null){
                book.setQuantityInCart(1);
                addBookToRepo(user, book);
//                book.setNoOfBooks(book.getNoOfBooks()-1);
            }
            Optional<BookModel> cartbook = books.stream().filter(t -> t.getBookId() == bookId).findFirst();
            if (cartbook.isPresent()) {
                return "Item is already present in the cart ";
            } else {
                book.setQuantityInCart(1);
                addBookToRepo(user, book);
                book.setNoOfBooks(book.getNoOfBooks()-1);
            }
        }else {
            return "Book is out of Stock !!!";
        }
        return "Item is added in cart !!!";
    }

    /**
     *
     * @param user
     * @param book
     * @return
     */
    public String addBookToRepo(UserRegistrationModel user, BookModel book){
        CartItem cart=new CartItem();
        cart.setUserRegistrationModel(user);
        cart.setBookModel(book);
        cart.setCreatedTime(LocalDateTime.now());
        cartRepository.save(cart);
        return "Item added successfully";
    }

    /**
     *
     * @param token
     * @return
     */
    @Override
    public List<BookModel> findBookList(String token){

        int userId = TokenUtil.decodeToken(token);

//        UserRegistrationModel user = userRepository.findById(userId).orElse(null);
        List<CartItem> booklist = cartRepository.findBookById(userId);
        List<BookModel> listOfBook = new ArrayList<BookModel>();
        for (CartItem cartItem : booklist) {
            listOfBook.add(cartItem.getBookModel());
        }
        return listOfBook;
    }

    /**
     *
     * @param bookId
     * @param token
     * @return
     */
    @Override
    public String deleteBookFromCart( int bookId ,String token) {
        int userId = TokenUtil.decodeToken(token);
        cartRepository.deleteByBookIdandId(bookId, userId);
        return "Book deleted Successfully from cart !!!";
    }

    /**
     *
     * @param token
     * @return
     */
    @Override
    public String emptyCart(String token){
        int userId = TokenUtil.decodeToken(token);
        UserRegistrationModel user = userRepository.findById(userId).orElse(null);
        List<CartItem> booklist = cartRepository.findBookById(userId);

        for (CartItem cartItem : booklist) {
            cartRepository.deleteById(cartItem.getCartId());
        }

        return "Cart is Empty";
    }
}
