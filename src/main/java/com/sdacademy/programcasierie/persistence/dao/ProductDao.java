package com.sdacademy.programcasierie.persistence.dao;

import com.sdacademy.programcasierie.persistence.model.ProductModel;

public class ProductDao extends ModelDao<ProductModel> {

    public ProductDao() {
        super("products.txt");
    }
}
