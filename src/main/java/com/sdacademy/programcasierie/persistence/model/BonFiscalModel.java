package com.sdacademy.programcasierie.persistence.model;

import java.util.List;

public class BonFiscalModel extends Model {

    List<ProductModel> cartList;
    int nrBon;


    public void setCartList(List<ProductModel> cartList) {
        this.cartList = cartList;
    }

    public List<ProductModel> getCartList() {
        return cartList;
    }

    public int getNrBon() {
        return nrBon;
    }

    public void setNrBon(int nrBon) {
        this.nrBon = nrBon;
    }
}
