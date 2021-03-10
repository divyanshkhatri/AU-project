package com.accolite.dao;

import java.util.List;

import com.accolite.model.Product;
import com.accolite.model.ProductDetails;

public interface ProductDAO {
	
	public Product save(ProductDetails product);
	
	public List<Product> list(int offset,int limit);

}
