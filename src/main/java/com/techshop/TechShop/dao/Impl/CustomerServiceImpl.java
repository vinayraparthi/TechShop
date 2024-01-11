package com.techshop.TechShop.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.techshop.TechShop.dao.CustomerService;
import com.techshop.TechShop.entity.Customers;
import com.techshop.TechShop.exception.CustomerNotFoundException;
import com.techshop.TechShop.util.DBConnUtil;
import com.techshop.TechShop.util.DBPropertyUtil;

public class CustomerServiceImpl implements CustomerService{
	
	private Connection connection;
	public CustomerServiceImpl() {
        this.connection = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString());
        		
    }
	 public void viewAllCustomers() {
	        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
	            int columnCount = metaData.getColumnCount();

	            System.out.println("Column Names:");
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.println(metaData.getColumnName(i));
	            }

	            System.out.println("\nList of Customers:");
	            while (resultSet.next()) {
	                System.out.println("Customer ID: " + resultSet.getInt("CustomerID"));
	                System.out.println("First Name: " + resultSet.getString("FirstName"));
	                System.out.println("Last Name: " + resultSet.getString("LastName"));
	                System.out.println("Email: " + resultSet.getString("Email"));
	                System.out.println("Phone: " + resultSet.getString("Phone"));
	                System.out.println("Address: " + resultSet.getString("Address"));
	                System.out.println("------------------------");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	@Override
	public int calculateTotalOrders(int customerId) {
		
		try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM orders WHERE CustomerID = ?")){

	            preparedStatement.setInt(1, customerId);
	            
	            try(ResultSet resultSet = preparedStatement.executeQuery()){

	            if (resultSet.next()) {
	                return resultSet.getInt(1);
	            }
	            
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		return 0;
	}
	@Override
	public void getCustomerDetails(int customerId) {
	    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE CustomerID = ?")) {
	        preparedStatement.setInt(1, customerId);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                System.out.println("Customer ID: " + resultSet.getInt("CustomerID"));
	                System.out.println("First Name: " + resultSet.getString("FirstName"));
	                System.out.println("Last Name: " + resultSet.getString("LastName"));
	                System.out.println("Email: " + resultSet.getString("Email"));
	                System.out.println("Phone: " + resultSet.getString("Phone"));
	                System.out.println("Address: " + resultSet.getString("Address"));
	            }else {
	            	 System.out.println("Customer Not Found with ID: " + customerId);
	            }
	        }
	    } catch (SQLException e) {
	    	e.printStackTrace();
	        
	        System.out.println("An error occurred while retrieving product details.");
	    }
	}

	@Override
	public void updateCustomerInfo(Customers customers) {
		try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET Email=?, Phone=?, Address=? WHERE CustomerID = ?")) {

            preparedStatement.setString(1, customers.getEmail());
            preparedStatement.setString(2, customers.getPhone());
            preparedStatement.setString(3, customers.getAddress());
            preparedStatement.setInt(4, customers.getCustomerID());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Customer information updated successfully.");
            } else {
                System.out.println("Failed to update customer information.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	public void createNewCustomer(Customers customers) {
	    try (PreparedStatement preparedStatement = connection.prepareStatement(
	            "INSERT INTO customers (CustomerID,FirstName, LastName, Email, Phone, Address) VALUES (?,?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, customers.getCustomerID());
	        preparedStatement.setString(2, customers.getFirstName());
	        preparedStatement.setString(3, customers.getLastName());
	        preparedStatement.setString(4, customers.getEmail());
	        preparedStatement.setString(5, customers.getEmail());
	        preparedStatement.setString(6, customers.getAddress());

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("New customer created successfully!");
	        } else {
	            System.out.println("Failed to create a new customer.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	
		
		

}
