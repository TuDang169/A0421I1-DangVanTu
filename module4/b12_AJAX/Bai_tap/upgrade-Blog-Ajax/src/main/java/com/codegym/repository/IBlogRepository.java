package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog ,Long> {
    Optional<Blog> findAllByCategory(Category category);
}
