package com.accolite.service;

import org.springframework.stereotype.Service;

import com.accolite.dao.impl.CustomerDAOImpl;
import com.accolite.model.Customer;
import com.accolite.model.CustomerData;

@Service
public class CustomerService {
	
	public static Customer createCustomer(Customer customer) {
		
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		
		Customer customerData = customerDAOImpl.save(customer);
		
		return customerData;
		
	}

public static CustomerData getCustomers(int offset, int limit) {
		
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		
		CustomerData customers = customerDAOImpl.list(offset, limit);
		
		return customers;
		
}


}
