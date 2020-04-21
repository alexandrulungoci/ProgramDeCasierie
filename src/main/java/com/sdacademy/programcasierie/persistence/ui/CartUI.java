package com.sdacademy.programcasierie.persistence.ui;

import com.sdacademy.programcasierie.persistence.dao.BonFiscalDao;
import com.sdacademy.programcasierie.persistence.model.BonFiscalModel;
import com.sdacademy.programcasierie.persistence.model.ProductModel;
import com.sdacademy.programcasierie.persistence.services.ProductService;
import com.sdacademy.programcasierie.persistence.services.exception.CategoryNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CartUI {

    List<ProductModel> cartList = new ArrayList<>();
    BonFiscalDao bonFiscalDao = new BonFiscalDao();
    Scanner scanner = new Scanner(System.in);
    private CategoryUI categoryUI = new CategoryUI();
    private ProductUI productUI = new ProductUI();
    private ProductService productService = new ProductService();
    Optional<ProductModel> productModel;
    ProductModel produsInCos;
    private int cantCart;
    int countBon = 1;
    String currency;


    public void cumparaProduse() throws CategoryNotFoundException {
        categoryUI.printCategories();
        System.out.println("Din ce categorie doresti sa cumperi?");
        String id = scanner.next();
        productUI.printByCateg(id);
        System.out.println("alege produs");
        String idProd = scanner.next();
        scanner.nextLine();
        System.out.println("introdu cantitatea");
        cantCart = scanner.nextInt();
        productModel = productService.findById(idProd);
        produsInCos = productModel.get();
        produsInCos.setCantInCos(cantCart);
        cartList.add(produsInCos);
        afisareCart();
    }

    public void afisareCart() {
        double totalCos = 0;
        char ch = '/';
        for (ProductModel produsCart : cartList) {
            System.out.println(produsCart.getId() + " " + produsCart.getName() + " , " + produsCart.getCantInCos()
                    + " " + produsCart.getUnitateDeMasura() + " " + produsCart.getPrice() + " " + produsCart.getCurrency()
                    + ch + produsCart.getUnitateDeMasura() + " Pret total: "
                    + (produsCart.getCantInCos() * produsCart.getPrice()) + " " + produsCart.getCurrency());
            totalCos += (produsCart.getCantInCos() * produsCart.getPrice());
            currency = produsCart.getCurrency();
        }
        System.out.println("Total general: " + totalCos + " " + currency);
    }

    public void stergeProdusDinCos() {
        afisareCart();
        System.out.println("Alege produs pentru eliminare din cos");
        String idStergere = scanner.next();
        for (ProductModel produsDinCos : cartList) {
            if (produsDinCos.getId().equals(idStergere)) {
                cartList.remove(produsDinCos);
            }
            System.out.println();
            afisareCart();
            System.out.println();
        }
    }

    public void finalizeazaComanda() {
        System.out.println();
        afisareCart();
        System.out.println();
        for (int i = 0; i < cartList.size(); i++) {
            ProductModel produs = cartList.get(i);
            Optional<ProductModel> produsGasit = productService.findById(produs.getId());
            if (produsGasit.isPresent()) {
                productService.removeProduct(produs.getId());
                ProductModel produsStock = produsGasit.get();
                int stocNou = produsStock.getStock() - produs.getCantInCos();
                produsStock.setStock(stocNou);
                productService.addProduct(produsStock);
            }
        }

        BonFiscalModel bonFiscal = new BonFiscalModel();
        bonFiscal.setNrBon(getBonNr() + 1);
        bonFiscal.setCartList(cartList);
        bonFiscalDao.add(bonFiscal);
        System.out.println("Lista produse dupa finalizare");
        productUI.printProducts();
        cartList.clear();
        countBon++;
    }

    public int getBonNr() {
        List<BonFiscalModel> bonList = bonFiscalDao.getAll();
        if (bonList == null || bonList.isEmpty()) {
            return 0;
        }
        return bonList.size();
    }

}