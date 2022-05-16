package model.service.impl;

import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;
import model.repository.impl.CustomerTypeRepostoryImpl;
import model.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepostoryImpl();
    @Override
    public List<CustomerType> findByAll() {
        return customerTypeRepository.findByAll();
    }
}
