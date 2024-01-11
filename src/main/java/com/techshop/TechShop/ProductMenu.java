package com.techshop.TechShop;

import java.util.Scanner;

import com.techshop.TechShop.dao.OrdersService;
import com.techshop.TechShop.dao.ProductService;
import com.techshop.TechShop.dao.Impl.OrdersServiceImpl;
import com.techshop.TechShop.dao.Impl.ProductServieImpl;
import com.techshop.TechShop.entity.Customers;
import com.techshop.TechShop.entity.Products;

public class ProductMenu {
	
	static ProductService productService = new ProductServieImpl();
	
	public boolean OrderDetailsMenu() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			 System.out.println("\n********** Product Menue **********");
			 System.out.println("1. getProductDetails");
			 System.out.println("2. updateProductInfo");
			 System.out.println("3. isProductInStock");
			 System.out.println("4. Exit");
             System.out.print("Enter your choice: ");
       	 int customerchoice = scanner.nextInt();
       	 switch(customerchoice) {
       	 case 1:
       		 System.out.println("\n********** Product Menue **********");
       		 System.out.print("Enter the product Id: ");
       		 int id = scanner.nextInt();
       		 productService.getProductDetails(id);
       		 break;
       	 case 2:
       		 System.out.println("\n********** Product Menue **********");
       		 scanner.nextLine();
       		 Products product = new Products();
       		 System.out.print("Enter Product ID Which You Want To Update: ");
       		 product.setProductID(scanner.nextInt());
       		 scanner.nextLine();
   		 	 System.out.print("Update Product Name: ");
   		 	 product.setProductName(scanner.nextLine());
   		 	 System.out.print("Update Description: ");
   		 	 product.setDescription(scanner.nextLine());
   		 	 System.out.print("Update the price: ");
   		 	 product.setPrice(scanner.nextDouble());
   		 	 productService.updateProductInfo(product);
       		 break;
       	 case 3:
       		System.out.println("\n********** Product Menue **********");
       		System.out.print("Enter The Product Id:");
       		int productid = scanner.nextInt();
       		boolean isInStock = productService.isProductInStock(productid);
       		if (isInStock) {
       		    System.out.println("Product is in stock.");
       		} else {
       		    System.out.println("Product is out of stock.");
       		}
       		 break;
       	 case 4:
       		 System.out.println("Returning to Main Menu.");
                return false;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
       	
       	 
       	 }
			 
		 }
	}

}
