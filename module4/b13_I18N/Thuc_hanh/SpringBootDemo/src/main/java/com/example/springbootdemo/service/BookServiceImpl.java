package com.example.springbootdemo.service;

import com.example.springbootdemo.aspect.LoggingAspect;
import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getList() {
        System.out.println("---------- Get list ----------");
        Iterable<Book> iterable = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (Book b: iterable) {
            bookList.add(b);
        }
        return bookList;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findByNameContains(name);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
