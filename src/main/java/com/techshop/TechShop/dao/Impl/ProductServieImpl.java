package com.techshop.TechShop.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techshop.TechShop.dao.ProductService;
import com.techshop.TechShop.entity.Products;
import com.techshop.TechShop.util.DBConnUtil;
import com.techshop.TechShop.util.DBPropertyUtil;

public class ProductServieImpl implements ProductService{
	
	private Connection connection;
	
	public ProductServieImpl() {
        this.connection = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString());
        		
    }

	@Override
	public void getProductDetails(int productId) {
	    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE ProductID = ?")) {
	        preparedStatement.setInt(1, productId);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                System.out.println("Product ID: " + resultSet.getInt("ProductID"));
	                System.out.println("Product Name: " + resultSet.getString("ProductName"));
	                System.out.println("Description: " + resultSet.getString("Description"));
	                System.out.println("Price: " + resultSet.getDouble("Price"));
	            } else {
	                System.out.println("Product not found with ID: " + productId);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	}

	@Override
	public void updateProductInfo(Products product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE products SET ProductName=?, Description=?, Price=?, StockQuantity=? WHERE ProductID=?")) {

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(5, product.getProductID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product information updated successfully.");
            } else {
                System.out.println("Failed to update product information.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean isProductInStock(int productId) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT QuantityInStock FROM inventory WHERE ProductID = ?")) {

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int stockQuantity = resultSet.getInt("QuantityInStock");
                    return stockQuantity > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}


}
