package com.sdacademy.programcasierie.persistence.services;

import com.sdacademy.programcasierie.persistence.dao.CategoryDao;
import com.sdacademy.programcasierie.persistence.model.CategoryModel;
import com.sdacademy.programcasierie.persistence.services.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public List<CategoryModel> getAllCategories() {
        List<CategoryModel> categories = categoryDao.getAll();
        return categories;
    }

    public void addCategory(String code, String name) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(code);
        categoryModel.setName(name);
        categoryDao.add(categoryModel);
    }

    public CategoryModel getCategoryById(String code) throws CategoryNotFoundException {
        Optional<CategoryModel> categoryModelOptional = categoryDao.findById(code);
        if (categoryModelOptional.isPresent()) {
            return categoryModelOptional.get();
        } else {
            throw new CategoryNotFoundException();
        }
    }

    public void removeCategory(String id) {
        categoryDao.remove(id);
    }

}
