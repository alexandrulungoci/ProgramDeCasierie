package com.sdacademy.programcasierie.persistence.services.exception;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException() {
        super("Category Not Found!");
    }
}
