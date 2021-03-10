package com.accolite.dao;

import com.accolite.model.Customer;
import com.accolite.model.CustomerData;

public interface CustomerDAO {
	
	public Customer save(Customer customer);
	
	public CustomerData list(int offset, int limit);


}
