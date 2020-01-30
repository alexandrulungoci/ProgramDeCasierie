package com.sdacademy.programcasierie.persistence.ui;

import com.sdacademy.programcasierie.persistence.model.CategoryModel;
import com.sdacademy.programcasierie.persistence.model.ProductModel;
import com.sdacademy.programcasierie.persistence.services.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class StockManagementUI {

    Scanner scanner = new Scanner(System.in);
    ProductUI productUI = new ProductUI();
    CategoryUI categoryUI = new CategoryUI();
    ProductService productService = new ProductService();

    public void stockManagement() {
        int optionStock = 0;
        while (optionStock != 5) {
            printMenuStock();
            optionStock = scanner.nextInt();
            if (optionStock == 1) {
                addStockProduct();
            } else if (optionStock == 2) {
                productUI.addProduct();
            } else if (optionStock == 3) {
                editProduct();
            } else if (optionStock == 4) {
                categoryUI.addCategory();
            }
        }
    }

    private void printMenuStock() {
        System.out.println("Alegeti optiunea:");
        System.out.println("1.Adaugare stoc produse");
        System.out.println("2.Adaugare produs nou");
        System.out.println("3.Editare produs");
        System.out.println("4.Adaugare Categorie");
        System.out.println("5.Exit");
    }

    public void addStockProduct() {
        productUI.printProducts();
        System.out.println("Alegeti codul produsului");
        String id = scanner.next();
        System.out.println("Introdu cantitate de adaugat in stoc");
        int adaugaStoc = scanner.nextInt();
        productService.addStockProduct(id, adaugaStoc);
    }

    public void editProduct() {
        productUI.printProducts();
        System.out.println("Alege cod produs pentru editare");
        String idEdit = scanner.next();
        scanner.nextLine();
        Optional<ProductModel> produsGasit = productService.findById(idEdit);
        ProductModel produs = produsGasit.get();
        System.out.println(produs.getName() + " " + produs.getStock());
        printEditMenu();
        int optionEdit = 0;
        while (optionEdit != 5) {
            optionEdit = scanner.nextInt();
            if (optionEdit == 1) {
                modificaCod(idEdit);
            } else if (optionEdit == 2) {
                modificaNume(idEdit);
            } else if (optionEdit == 3) {
                modificaPret(idEdit);
            } else if (optionEdit == 4) {
                modificaCategoria(produs);
            }
        }
    }

    private void printEditMenu() {
        System.out.println("Alegeti optiunea:");
        System.out.println("1.Modifica codul ");
        System.out.println("2.Modifica numele");
        System.out.println("3.Modifica pretul");
        System.out.println("4.Modifica categoria");
        System.out.println("5.Exit");
    }

    public void modificaCod(String id) {
        System.out.println("Introdu cod nou");
        String codNou = scanner.next();
        productService.modificaCod(id, codNou);
    }

    public void modificaNume(String id) {
        System.out.println("Introdu nume nou");
        String numeNou = scanner.next();
        scanner.nextLine();
        productService.modificaNume(id, numeNou);
    }

    public void modificaPret(String id) {
        System.out.println("Introdu pret nou");
        double pretNou = scanner.nextDouble();
        productService.modificaPret(id, pretNou);
    }

    public void modificaCategoria(ProductModel produs) {
        System.out.println("alege noua categorie");
        categoryUI.printCategories();
        CategoryModel categoryModel = categoryUI.readCategory();
        produs.setCategory(categoryModel);
        productService.modificaCategoria(produs.getId(), categoryModel);
    }

}
