package com.sdacademy.programcasierie.persistence;

import com.sdacademy.programcasierie.persistence.services.exception.CategoryNotFoundException;
import com.sdacademy.programcasierie.persistence.ui.AppUI;

public class Main {

    public static void main(String[] args) throws CategoryNotFoundException {
        new AppUI().startProgram();
    }

}
