package com.sdacademy.programcasierie.persistence.ui;

import com.sdacademy.programcasierie.persistence.model.CategoryModel;
import com.sdacademy.programcasierie.persistence.services.CategoryService;
import com.sdacademy.programcasierie.persistence.services.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Scanner;

public class CategoryUI {

    private Scanner scanner = new Scanner(System.in);
    private CategoryService categoryService = new CategoryService();

    public void addCategory() {
        System.out.println("Introduceti codul categoriei:");
        String code = scanner.next();
        scanner.nextLine();
        System.out.println("Introduceti numele categoriei:");
        String name = scanner.nextLine();
        categoryService.addCategory(code, name);
    }

    public void printCategories() {
        printCategories(categoryService.getAllCategories());
    }

    public CategoryModel readCategory() {
        CategoryModel categoryFound = null;
        while (categoryFound == null) {
            String categoryCode = scanner.next();
            scanner.nextLine();
            try {
                categoryFound = categoryService.getCategoryById(categoryCode);
            } catch (CategoryNotFoundException e) {
                System.out.println("Please choose the code of the categories bellow!");
                printCategories(categoryService.getAllCategories());
            }
        }
        return categoryFound;
    }

    private void printCategories(List<CategoryModel> categories) {
        if (categories == null || categories.isEmpty()) {
            System.out.println("No categories found in the system!");
            return;
        }
        categories.forEach(category -> {
            printCategory(category);
            System.out.println();
        });
    }

    private void printCategory(CategoryModel category) {
        System.out.print(category.getId() + " " + category.getName());
    }

}
