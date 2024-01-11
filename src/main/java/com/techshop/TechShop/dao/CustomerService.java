package com.techshop.TechShop.dao;

import com.techshop.TechShop.entity.Customers;

public interface CustomerService {
	
	public void viewAllCustomers();
	public int calculateTotalOrders(int customerId);
	public void getCustomerDetails(int customerId);
	public void updateCustomerInfo(Customers customers);
	public void createNewCustomer(Customers customers);

}
