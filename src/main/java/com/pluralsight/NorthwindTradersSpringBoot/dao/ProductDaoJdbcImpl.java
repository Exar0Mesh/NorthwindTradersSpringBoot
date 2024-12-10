package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoJdbcImpl implements ProductDao{
    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public ProductDaoJdbcImpl(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }
    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void deleteById(int ProductId) {

    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT ProductID, ProductName, CategoryName, UnitPrice FROM Products;";
        //Im gonna have to connect them together with JOIN
        try(Connection connection = dataSource.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(sql);
            while(rows.next()){
                this.products.add(new Product(rows.getInt(1), rows.getString(2), rows.getString(3),rows.getDouble(4)));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return this.products;
    }
}
