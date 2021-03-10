package com.accolite.dao;

import java.util.List;

import com.accolite.model.Supplier;

public interface SupplierDAO {
	
public Supplier save(Supplier supplier);
	
public List<Supplier> list(int offset,int limit);

}
