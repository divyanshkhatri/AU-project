package com.accolite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accolite.dao.impl.CustomerOrderDAOImpl;
import com.accolite.model.CustomerOrder;
import com.accolite.model.CustomerOrderDetails;
import com.accolite.model.Order;

@Service
public class CustomerOrderService {
	
	public static CustomerOrder createOrder(Order order) {
		
		CustomerOrderDAOImpl customerOrderImpl = new CustomerOrderDAOImpl();
		
		CustomerOrder customerOrderData = customerOrderImpl.save(order);
		
		return customerOrderData;
		
	}
	
    public static List<Order> getOrders(int offset, int limit) {
		
		CustomerOrderDAOImpl customerorderDAOImpl = new CustomerOrderDAOImpl();
		
		List<Order> orders = customerorderDAOImpl.list(offset, limit);
		
		return orders;
		
    }
    
    public static List<Order> getOrdersByCustomerId(int customerId) {
    	
    	CustomerOrderDAOImpl customerOrderDAOImpl = new CustomerOrderDAOImpl();
    	
    	List<Order> orders = customerOrderDAOImpl.getOrdersByCustomerId(customerId);
    	
    	return orders;
    }
    
    public static String updateOrderStatus(CustomerOrderDetails custOrder) {
    	
    	CustomerOrderDAOImpl customerOrderDAOImpl = new CustomerOrderDAOImpl();
    	
    	String count = customerOrderDAOImpl.updateOrderStatus(custOrder);
    	
    	return count;
    }

}
