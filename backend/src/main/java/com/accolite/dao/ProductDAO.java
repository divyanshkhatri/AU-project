package com.accolite.dao;

import java.util.List;

import com.accolite.model.Product;

public interface ProductDAO {
	
	public Product save(Product product);
	
	public List<Product> list(int offset,int limit);

}
