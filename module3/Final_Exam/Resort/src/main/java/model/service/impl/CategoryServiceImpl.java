package model.service.impl;

import model.bean.Category;
import model.repository.CategoryRepository;
import model.repository.impl.CategoryRepositoryImpl;
import model.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findByAll() {
        return categoryRepository.findByAll();
    }
}
