package com.pluralsight.NorthwindTradersSpringBoot.model;

public class Product {
    private int productID;
    private String name, category;
    private double price;

    public Product(int productID, String name, String category, double price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductId: " + this.productID + "\nName: " + this.name + "\nCategory: " + this.category + "\nPrice: " + this.price + "\n\n------------\n";
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
