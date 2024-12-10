package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDao {
    public void add(Product product);
    public void deleteById(int ProductId);
    public List<Product> getAll();
}
