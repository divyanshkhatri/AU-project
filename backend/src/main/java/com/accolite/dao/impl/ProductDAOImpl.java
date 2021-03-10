package com.accolite.dao.impl;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.dao.ProductDAO;
import com.accolite.model.Product;
import com.accolite.utils.Connection;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Product save(Product product) {
		
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
	
		Product productData = new Product();
		
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setProductOnHand(product.getProductOnHand());
		productData.setProductAvailable(product.getProductAvailable());
		productData.setProductOutgoing(product.getProductOutgoing());
		productData.setProductIncoming(product.getProductIncoming());
		productData.setProductcostPrice(product.getProductcostPrice());
		productData.setProductSellingPrice(product.getProductSellingPrice());
	

		 session.save(productData);
         tx.commit();
		
		return productData;
		
	}

	@Override
	public List<Product> list(int offset,int limit) {
		
		 Session session = Connection.getSession();
			
			Transaction tx = session.beginTransaction();
			
			Query query = session.createSQLQuery("select * from Product");
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			
			
			System.out.println(limit + " " + offset);
			@SuppressWarnings("unchecked")
			
			List<Object[]> obj = query.getResultList();
		
			List<Product> products = new ArrayList<>();
			
			for(Object[] o : obj) {
				
				Product product=new Product();
				
				product.setProductAvailable((int)o[1]);;
				product.setProductcostPrice((int)o[7]);
				product.setProductId((int)o[0]);
				product.setProductIncoming((int)o[2]);
				product.setProductName((String)o[3]);
				product.setProductOnHand((int)o[4]);
				product.setProductOutgoing((int)o[5]);
				product.setProductSellingPrice((int)o[6]);
				
				products.add(product);
				
				
			}
			
			tx.commit();
			
			return products;
	}}		
	