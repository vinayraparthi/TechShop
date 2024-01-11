package com.techshop.TechShop;

import java.util.Scanner;

import com.techshop.TechShop.dao.CustomerService;
import com.techshop.TechShop.dao.Impl.CustomerServiceImpl;
import com.techshop.TechShop.entity.Customers;

public class CustomerMenu {
	
	static CustomerService customerService = new CustomerServiceImpl();
	
	public boolean CustomermenuDetails() {
		
		Scanner scanner = new Scanner(System.in);
		 while (true) {
			 System.out.println("\n********** Customer Menu **********");
        	 System.out.println("1. View All Customers Details");
        	 System.out.println("2. View Customer Details By ID");
        	 System.out.println("3. View Create User");
        	 System.out.println("4. View calculateTotalOrders");
        	 System.out.println("5. updateCustomerInfo");
        	 System.out.println("6. Exit");
             System.out.print("Enter your choice: ");
        	 int customerchoice = scanner.nextInt();
        	 switch(customerchoice) {
        	 case 1:
        		 System.out.println("\n********** Customer Menu **********");
        		 customerService.viewAllCustomers();
        		 break;
        	 case 2:
        		 System.out.println("\n********** Customer Menu **********");
        		 System.out.print("Enter The Customer Id: ");
        		 int customerid = scanner.nextInt();
        		 scanner.nextLine();
        		 customerService.getCustomerDetails(customerid);
        		 break;
        	 case 3:
        		 scanner.nextLine();
        		 Customers customers = new Customers();
        		 System.out.println("\n********** Customer Menu **********");
        		 System.out.print("Enter CusomerId: ");
        	     customers.setCustomerID(scanner.nextInt());
        	     scanner.nextLine();
        		 System.out.print("Enter First Name: ");
        	     customers.setFirstName(scanner.nextLine());

        	     System.out.print("Enter Last Name: ");
        	     customers.setLastName(scanner.nextLine());

        	     System.out.print("Enter Email: ");
        	     customers.setEmail(scanner.nextLine());

        	     System.out.print("Enter Phone: ");
        	     customers.setPhone(scanner.nextLine());

        	     System.out.print("Enter Address: ");
        	     customers.setAddress(scanner.nextLine());
        	     customerService.createNewCustomer(customers);
        		 break;
        		 
        	 case 4: 
        		 System.out.println("\n********** Customer Menu **********");
        		 System.out.print("Enter The Customer Id: ");
        		 int customer_order = scanner.nextInt();
        		 System.out.println("Total Orders are : "+customerService.calculateTotalOrders(customer_order)); 
        		 break;
        	 case 5:
        		 System.out.println("\n********** Customer Menu **********");
        		 scanner.nextLine();
        		 Customers updatecustomer = new Customers();
        		 System.out.println("\n********** Customer Menu **********");
        		 System.out.print("Enter CusomerId You Want To Update: ");
        	     updatecustomer.setCustomerID(scanner.nextInt());
        	     scanner.nextLine();
        		 System.out.print("Enter First Name: ");
        		 updatecustomer.setFirstName(scanner.nextLine());

        	     System.out.print("Enter Last Name: ");
        	     updatecustomer.setLastName(scanner.nextLine());

        	     System.out.print("Enter Email: ");
        	     updatecustomer.setEmail(scanner.nextLine());

        	     System.out.print("Enter Phone: ");
        	     updatecustomer.setPhone(scanner.nextLine());

        	     System.out.print("Enter Address: ");
        	     updatecustomer.setAddress(scanner.nextLine());
        	     customerService.updateCustomerInfo(updatecustomer);
        		 
        		 break;
        		 
        	 case 6:
        		 System.out.println("Returning to Main Menu.");
                 return false;
             default:
                 System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        	        	 
        	 }
			 
		 }
		
	}

}
