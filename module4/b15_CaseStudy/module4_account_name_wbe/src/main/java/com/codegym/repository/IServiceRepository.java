package com.codegym.repository;

import com.codegym.model.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends PagingAndSortingRepository<Service, Long> {
}
