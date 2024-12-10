package com.pluralsight.NorthwindTradersSpringBoot.cli;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindCli implements CommandLineRunner {

    private final MenuHandler menuHandler;
    private ProductDao productDao;

    @Autowired
    public NorthwindCli(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }
    @Override
    public void run(String... args) throws Exception {
        menuHandler.showMainMenu();

        Scanner scanner = new Scanner(System.in);
        System.out.print("--Northwind Products--\n\nView All Products (1)\nAdd a Film    (2)\nExit          (0)\n\nEnter an Option: ");
        String option = scanner.nextLine();

        switch (option) {
            case "0" -> {
                System.out.println("Thank you for visiting Northwind Data");
                System.exit(0);
            }
            case "1" -> {
                System.out.println("\n------------\n");
                productDao.getAll().stream().forEach(product -> System.out.println(product));

                try{Thread.sleep(1500);} catch(InterruptedException e) { /*ignore*/ };
                run();
            }
            case "2" -> {
                System.out.println("\n------------\n--Please add Product info--");
                System.out.print("ProductID: ");
                int productID = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Category: ");
                String category = scanner.nextLine();

                System.out.print("Price: ");
                Double price = scanner.nextDouble();

                productDao.add(new Product(productID, title, category, price));

                try{Thread.sleep(1500);} catch(InterruptedException e) { /*ignore*/ };
                run();
            }
        }
    }
}
