package com.sdacademy.programcasierie.persistence.ui;

import com.sdacademy.programcasierie.persistence.services.exception.CategoryNotFoundException;

import java.util.Scanner;

public class AppUI {

    private Scanner scanner = new Scanner(System.in);
    StockManagementUI stockManagementUI = new StockManagementUI();
    CartUI cartUI = new CartUI();

    public void startProgram() throws CategoryNotFoundException {
        int option = 0;
        while (option != 5) {
            printMenu();
            option = scanner.nextInt();
            if (option == 1) {
                cartUI.cumparaProduse();
            } else if (option == 2) {
                stockManagementUI.stockManagement();
            } else if (option == 3) {
                cartUI.stergeProdusDinCos();
            } else if (option == 4) {
                cartUI.finalizeazaComanda();
            }
        }
    }

    private void printMenu() {
        System.out.println("Bine ati venit la Casierie");
        System.out.println("Alegeti optiunea:");
        System.out.println("1.Cumpara produse");
        System.out.println("2.Stock Management");
        System.out.println("3.Sterge produs din cos");
        System.out.println("4.Finalizeaza comanda");
        System.out.println("5.Exit");
    }

}
