package com.codegym.repository;

import com.codegym.model.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Long> {
}
