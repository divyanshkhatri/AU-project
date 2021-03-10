package com.accolite.service;

import java.util.List;

import com.accolite.dao.impl.OrderProductDAOImpl;
import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;

public class OrderProductService {
	
	public static OrderProduct createOrderProduct(OrderProductDetails orderproductdetails) {
		
		OrderProductDAOImpl orderProductImpl = new OrderProductDAOImpl();
		
		OrderProduct OrderProductData = orderProductImpl.save(orderproductdetails);
		
		return OrderProductData;
		
	}
	
	public static List<OrderProductDetails> getProductsByOrderId(int orderId) {
		
		OrderProductDAOImpl orderProductImpl = new OrderProductDAOImpl();
		
		List<OrderProductDetails> orderProducts = orderProductImpl.getProductsByOrderId(orderId);
		
		return orderProducts;
		
	}

}
