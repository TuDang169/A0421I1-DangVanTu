package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}