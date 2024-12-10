package com.pluralsight.NorthwindTradersSpringBoot;

//import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
	}
/*
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
		productDao = context.getBean(SimpleProductDao.class);
		runScreen();
	}
	public static void runScreen() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n1. List Employees, 2. Add Employees: ");
		String option = scanner.nextLine();
		switch (option) {
			case "1" -> productDao.getAll().stream().forEach(product -> System.out.println(product));

			case "2" -> { SimpleProductDao adding = new SimpleProductDao();
				System.out.println("What is the name of the product?: ");
				String name = scanner.nextLine();
				System.out.println("What is the products category?: ");
				String category = scanner.nextLine();
				System.out.println("What is the products price?: ");
				Double price = scanner.nextDouble();
				adding.add(new Product(4, name, category, price));
			}
		}
	}

 */

}
