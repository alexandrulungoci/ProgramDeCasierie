package com.sdacademy.programcasierie.persistence.services;

import com.sdacademy.programcasierie.persistence.dao.CategoryDao;
import com.sdacademy.programcasierie.persistence.dao.ProductDao;
import com.sdacademy.programcasierie.persistence.model.CategoryModel;
import com.sdacademy.programcasierie.persistence.model.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    private ProductDao productDao = new ProductDao();
    private CategoryDao categoryDao = new CategoryDao();

    public void addProduct(ProductModel product) {
        productDao.add(product);
    }

    public List<ProductModel> listProducts() {
        return productDao.getAll();
    }

    public Optional<ProductModel> findById(String id) {
        Optional<ProductModel> produsGasit = productDao.findById(id);
        return produsGasit;
    }

    public void removeProduct(String id) {
        productDao.remove(id);
    }

    public void addStockProduct(String id, int adaugaStoc) {
        Optional<ProductModel> produsGasit = findById(id);
        if (produsGasit.isPresent()) {
            removeProduct(id);
            ProductModel produs = produsGasit.get();
            int stocNou = produs.getStock() + adaugaStoc;
            produs.setStock(stocNou);
            addProduct(produs);
        }
    }

    public void modificaCod(String id, String codNou) {
        Optional<ProductModel> produsGasit = findById(id);
        if (produsGasit.isPresent()) {
            removeProduct(id);
            ProductModel produs = produsGasit.get();
            produs.setId(codNou);
            addProduct(produs);
        }
    }

    public void modificaNume(String id, String numeNou) {
        Optional<ProductModel> produsGasit = findById(id);
        if (produsGasit.isPresent()) {
            removeProduct(id);
            ProductModel produs = produsGasit.get();
            produs.setName(numeNou);
            addProduct(produs);
        }
    }

    public void modificaPret(String id, double pretNou) {
        Optional<ProductModel> produsGasit = findById(id);
        if (produsGasit.isPresent()) {
            removeProduct(id);
            ProductModel produs = produsGasit.get();
            produs.setPrice(pretNou);
            addProduct(produs);
        }
    }

    public void modificaCategoria(String id, CategoryModel categoryModel) {
        Optional<ProductModel> produsGasit = findById(id);
        if (produsGasit.isPresent()) {
            removeProduct(id);
            ProductModel produs = produsGasit.get();
            produs.setCategory(categoryModel);
            addProduct(produs);
        }
    }

    public List<ProductModel> returnProductsByCategory(String code) {
        Optional<CategoryModel> categoryModelOptional = categoryDao.findById(code);
        if (categoryModelOptional.isPresent()) {
            CategoryModel categoryModel = categoryModelOptional.get();
            return productDao.getAll().stream().filter(productModel ->
                    productModel.getCategory().getId()
                            .equals(categoryModel.getId()))
                    .collect(Collectors.toList());

        }
        return new ArrayList<>();
    }
}