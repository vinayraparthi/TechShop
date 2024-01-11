package com.techshop.TechShop.dao;

import com.techshop.TechShop.entity.Products;

public interface ProductService {
	
    void getProductDetails(int productId);

    void updateProductInfo(Products product);

    boolean isProductInStock(int productId);

}
