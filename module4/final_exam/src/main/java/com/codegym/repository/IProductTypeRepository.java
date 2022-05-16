package com.codegym.repository;

import com.codegym.model.ProductType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends PagingAndSortingRepository<ProductType, Long> {
}
