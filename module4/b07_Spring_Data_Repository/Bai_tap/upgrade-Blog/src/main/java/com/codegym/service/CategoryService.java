package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository CategoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return CategoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return CategoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        CategoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        CategoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findAllByNameContaining(String name, Pageable pageable) {
        return CategoryRepository.findAllByNameContaining(name, pageable);
    }
}
