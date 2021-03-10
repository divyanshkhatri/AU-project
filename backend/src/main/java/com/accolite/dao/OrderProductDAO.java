package com.accolite.dao;

import java.util.List;

import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;

public interface OrderProductDAO {
	
	public OrderProduct save(OrderProductDetails orderproductdetails);
	
	public List<OrderProductDetails> getProductsByOrderId(int orderId);

}
