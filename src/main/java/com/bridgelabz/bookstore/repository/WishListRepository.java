package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Integer> {

    @Query(value = "select * from wishbook where book_id=?", nativeQuery = true)
    List<WishList> findBookById(int userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM wishbook WHERE book_id =? and id=?", nativeQuery = true)
    void deleteByBookIdandId(int bookId, int Id);
}