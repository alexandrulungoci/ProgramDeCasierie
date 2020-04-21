package com.sdacademy.programcasierie.persistence.model;

public class ProductModel extends Model {

    private String name;
    private double price;
    private CategoryModel category;
    private String currency;
    private int stock = 0;
    private int cantInCos;
    private UnitateDeMasura unitateDeMasura;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantInCos() {
        return cantInCos;
    }

    public void setCantInCos(int cantInCos) {
        this.cantInCos = cantInCos;
    }

    public UnitateDeMasura getUnitateDeMasura() {
        return unitateDeMasura;
    }

    public void setUnitateDeMasura(UnitateDeMasura unitateDeMasura) {
        this.unitateDeMasura = unitateDeMasura;
    }
}
