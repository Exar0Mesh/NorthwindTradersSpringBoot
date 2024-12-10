package com.pluralsight.NorthwindTradersSpringBoot.cli;

import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.ProductInputScreen;
import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.ProductListScreen;
import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.MenuScreen;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import com.pluralsight.NorthwindTradersSpringBoot.service.ProductService;
import com.pluralsight.NorthwindTradersSpringBoot.util.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuHandler extends Loggable {
    private final MenuScreen menuScreen;
    private final ProductListScreen productListScreen;
    private final ProductInputScreen productInputScreen;
    private final ProductService productService;
    private final ConsoleUtils consoleUtils;

    @Autowired
    public MenuHandler(MenuScreen menuScreen,
                       ProductListScreen productListScreen,
                       ProductInputScreen productInputScreen,
                       ProductService productService,
                       ConsoleUtils consoleUtils) {
        this.menuScreen = menuScreen;
        this.productListScreen = productListScreen;
        this.productInputScreen = productInputScreen;
        this.productService = productService;
        this.consoleUtils = consoleUtils;
    }

    public void showMainMenu() {
        menuScreen.displayMenu();
        String option = consoleUtils.getUserInput();
        handleUserOption(option);
    }

    private void handleUserOption(String option) {
        switch (option) {
            case "0" -> exitScreen();
            case "1" -> showAllProducts();
            case "2" -> addNewProduct();
            case "3" -> deleteProduct();
            default -> {
                System.out.println("Invalid option. Please try again.");
                showMainMenu();
            }
        }
    }

    private void showAllProducts() {
        productListScreen.displayAllProducts(productService.getAllProduct());
        consoleUtils.pauseBriefly();
        showMainMenu();
    }

    private void addNewProduct() {
        productService.addProduct(productInputScreen.promptForProduct());
        consoleUtils.pauseBriefly();
        showMainMenu();
    }

    private void deleteProduct() {
        productService.deleteById(productInputScreen.promptForProductId());
        consoleUtils.pauseBriefly();
        showMainMenu();
    }

    private void exitScreen() {
        System.out.println("Thank you for visiting the Northwind Data");
        System.exit(0);
    }
}
