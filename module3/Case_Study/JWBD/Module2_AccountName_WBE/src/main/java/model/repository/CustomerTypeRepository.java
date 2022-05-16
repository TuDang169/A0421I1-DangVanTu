package model.repository;

import model.bean.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    public List<CustomerType> findByAll();
}
