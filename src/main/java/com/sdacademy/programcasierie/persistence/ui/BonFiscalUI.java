package com.sdacademy.programcasierie.persistence.ui;

import com.sdacademy.programcasierie.persistence.dao.BonFiscalDao;
import com.sdacademy.programcasierie.persistence.model.BonFiscalModel;
import com.sdacademy.programcasierie.persistence.model.ProductModel;

import java.util.List;

public class BonFiscalUI {

    BonFiscalDao bonFiscalDao = new BonFiscalDao();
    String currency;

    public void printBons() {
        printBonuri(bonFiscalDao.getAll());
    }

    private void printBonuri(List<BonFiscalModel> bonsList) {
        if (bonsList == null || bonsList.isEmpty()) {
            System.out.println("Nu am gasit bonuri in sistem");
            return;
        }
        bonsList.forEach(bonFiscal -> {
            printBon(bonFiscal);
        });
    }

    private void printBon(BonFiscalModel bonFiscal) {
        System.out.println("Nr. bon: " + bonFiscal.getNrBon());
        List<ProductModel> cartList = bonFiscal.getCartList();
        double totalBon = 0;
        char ch = '/';
        for (ProductModel produs : cartList) {
            System.out.println(produs.getName() + " "
                    + produs.getCantInCos() + " " + produs.getUnitateDeMasura() + " " + produs.getPrice()
                    + " " + produs.getCurrency() + ch + produs.getUnitateDeMasura() + " Total: "
                    + produs.getCantInCos() * produs.getPrice() + " " + produs.getCurrency());
            totalBon += (produs.getCantInCos() * produs.getPrice());
            currency = produs.getCurrency();
        }
        System.out.println("Total bon: " + totalBon + " " + currency);
    }

}
