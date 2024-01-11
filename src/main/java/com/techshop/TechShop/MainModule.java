package com.techshop.TechShop;

import java.util.Scanner;

import com.techshop.TechShop.dao.CustomerService;
import com.techshop.TechShop.dao.Impl.CustomerServiceImpl;
import com.techshop.TechShop.entity.Customers;

public class MainModule {
	static CustomerMenu customerMenu = new CustomerMenu();
	static ProductMenu productMenu = new ProductMenu();


	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n********** TechShop Menu **********");
            System.out.println("1. Customer Menu");
            System.out.println("2. Product Menu");
            System.out.println("3. Orders Menue");
            System.out.println("4. Inventory Menue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            boolean backToMainMenu;

            switch (choice) {
                case 1:
                	backToMainMenu = customerMenu.CustomermenuDetails();
                	if (!backToMainMenu) {
                        break;
                	}
                    break;
                case 2:
                	backToMainMenu = productMenu.OrderDetailsMenu();
                	if (!backToMainMenu) {
                        break;
                	}
                    break;
                case 3:
                    // Call a method to view orders
                    // viewOrders();
                    break;
                case 4:
                    // Call a method to view inventory
                    // viewInventory();
                    break;
                case 5:
                    System.out.println("Exiting TechShop. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
            
        }
        
    }
}
