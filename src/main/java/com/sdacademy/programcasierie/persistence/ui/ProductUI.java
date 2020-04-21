package com.sdacademy.programcasierie.persistence.ui;

import com.sdacademy.programcasierie.persistence.model.CategoryModel;
import com.sdacademy.programcasierie.persistence.model.ProductModel;
import com.sdacademy.programcasierie.persistence.model.UnitateDeMasura;
import com.sdacademy.programcasierie.persistence.services.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductUI {

    private Scanner scanner = new Scanner(System.in);
    private ProductService productService = new ProductService();
    private CategoryUI categoryUI = new CategoryUI();

    public void printProducts() {
        printProducts(productService.listProducts());
    }

    private void printProducts(List<ProductModel> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("No products found in the system!");
            return;
        }
        products.forEach(productModel -> {
            printProduct(productModel);
            System.out.println();
        });
    }

    void printProduct(ProductModel product) {
        char ch = '/';
        System.out.print(product.getId() + " " + product.getName() + " ("
                + product.getCategory().getName() + ") " + product.getPrice()
                 + " " + product.getCurrency() + ch + product.getUnitateDeMasura()+ " (" + product.getStock()
                + " " + product.getUnitateDeMasura() + " in stoc" + ")");
    }

    public void addProduct() {
        ProductModel newProduct = readNewProduct();
        productService.addProduct(newProduct);
        System.out.print("Produsul ");
        printProduct(newProduct);
        System.out.println(" a fost adaugat.");
    }

    private ProductModel readNewProduct() {
        ProductModel productModel = new ProductModel();
        System.out.println("Introduceti codul produsului:");
        String code = scanner.next();
        productModel.setId(code);
        scanner.nextLine();
        System.out.println("Introduceti numele produsului:");
        String nume = scanner.nextLine();
        productModel.setName(nume);
        System.out.println("Alegeti codul uneia dintre urmatoarele categorii:");
        categoryUI.printCategories();
        CategoryModel categoryModel = categoryUI.readCategory();
        productModel.setCategory(categoryModel);
        System.out.println("Introduceti pretul produsului");
        double price = scanner.nextDouble();
        productModel.setPrice(price);
        scanner.nextLine();
        System.out.println("Introduceti unitatea de masura");
        System.out.println("1 pentru KILOGRAME");
        System.out.println("2 pentru BUCATI");
        int unitateMasura = scanner.nextInt();
        if (unitateMasura == 1) {
            productModel.setUnitateDeMasura(UnitateDeMasura.KG);
        } else productModel.setUnitateDeMasura(UnitateDeMasura.BUCATA);
        scanner.nextLine();
        System.out.println("Introduceti moneda produsului");
        String currency = scanner.next();
        productModel.setCurrency(currency);
        scanner.nextLine();
        return productModel;
    }

    public void printByCateg(String id) {
        List<ProductModel> listByCategories = productService.returnProductsByCategory(id);
        printProducts(listByCategories);
    }

}
