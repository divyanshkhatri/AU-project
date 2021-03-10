package com.accolite.service;

import java.util.List;

import com.accolite.dao.impl.SupplierDAOImpl;
import com.accolite.model.Supplier;

public class SupplierService {
public static Supplier createSupplier(Supplier supplier) {
		
		SupplierDAOImpl supplierDAOImpl = new SupplierDAOImpl();
		
		Supplier supplierData=supplierDAOImpl.save(supplier);
		return supplierData;
		
		
	}

public static List<Supplier> getSuppliers(int offset, int limit) {
	
	SupplierDAOImpl supplierDAOImpl = new SupplierDAOImpl();
	
	List<Supplier> suppliers = supplierDAOImpl.list(offset, limit);
	
	return suppliers;
	
}



}
