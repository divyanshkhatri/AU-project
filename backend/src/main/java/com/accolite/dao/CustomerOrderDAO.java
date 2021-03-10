package com.accolite.dao;

import java.util.List;


import com.accolite.model.CustomerOrder;
import com.accolite.model.CustomerOrderDetails;
import com.accolite.model.Order;

public interface CustomerOrderDAO {
	
	public CustomerOrder save(Order order);
	
	public List<Order> list(int offset,int limit);
	
	public List<Order> getOrdersByCustomerId(int customerId);
	
	public String updateOrderStatus(CustomerOrderDetails customerOrderDetails);

}
