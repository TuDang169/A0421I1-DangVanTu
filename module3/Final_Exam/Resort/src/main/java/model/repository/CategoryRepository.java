package model.repository;

import model.bean.Category;

import java.util.List;

public interface CategoryRepository{
    public List<Category> findByAll();
}
