package com.pluralsight.NorthwindTradersSpringBoot.cli.screen;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.Scanner;

public class ProductInputScreen {
    private final Scanner scanner;

    public ProductInputScreen() {
        this.scanner = new Scanner(System.in);
    }

    public Product promptForProduct() {
        System.out.println("\n------------\n--Please enter product info to add--");

        System.out.print("Name: ");
        String title = scanner.nextLine();

        System.out.print("Category: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        String releaseYear = scanner.nextLine();

        return new Product(0, title, description, releaseYear);
    }

    public int promptForProductId() {
        System.out.println("\n------------\n--Please enter product info to delete--");

        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); //Consume CRLF

        return productId;
    }
}
