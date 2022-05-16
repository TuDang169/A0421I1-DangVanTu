package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
