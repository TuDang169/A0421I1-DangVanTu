package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
