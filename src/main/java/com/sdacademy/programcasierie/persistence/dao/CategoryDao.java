package com.sdacademy.programcasierie.persistence.dao;

import com.sdacademy.programcasierie.persistence.model.CategoryModel;

public class CategoryDao extends ModelDao<CategoryModel> {

    private static final String DEFAULT_CATEGORY_FILE = "categories.txt";

    public CategoryDao() {
        super(DEFAULT_CATEGORY_FILE);
    }
}
