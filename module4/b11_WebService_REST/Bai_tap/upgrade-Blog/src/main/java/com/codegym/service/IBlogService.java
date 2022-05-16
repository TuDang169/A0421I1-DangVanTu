package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;

import java.util.Optional;

public interface IBlogService extends IGeneralService<Blog> {
    Optional<Blog> findAllByCategory(Category category);
}
