package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    List<Book> findByNameContains(String name);

    @Query("Select b from Book b where b.name like :name")
    List<Book> searchAllByName(String name);
}
