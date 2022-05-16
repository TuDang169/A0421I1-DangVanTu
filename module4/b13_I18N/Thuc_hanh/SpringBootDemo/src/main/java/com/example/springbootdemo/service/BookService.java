package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getList();
    void save(Book book);
    void update(Book book);
    void deleteBookById(int id);
    List<Book> findByName(String name);
    Page<Book> findAll(Pageable pageable);
}
