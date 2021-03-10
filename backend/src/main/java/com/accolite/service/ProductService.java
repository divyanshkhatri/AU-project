package com.accolite.service;

import java.util.List;

import com.accolite.dao.impl.ProductDAOImpl;
import com.accolite.model.Product;

public class ProductService {
	
	
public static Product createProduct(Product product) {
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		
		Product productData = productDAOImpl.save(product);
		
		return productData;
		
	}

public static List<Product> getProducts(int offset, int limit) {
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		
		List<Product> products = productDAOImpl.list(offset, limit);
		
		return products;
		
}

}
