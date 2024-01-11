package com.techshop.TechShop.entity;

public class Products {

	private int productID;
    private String productName;
    private String description;
    private double price;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int productID, String productName, String description, double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
    
}
