package com.accolite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.dao.SupplierDAO;
import com.accolite.model.Supplier;
import com.accolite.utils.Connection;
import javax.persistence.Query;


public class SupplierDAOImpl implements SupplierDAO {
	
	//@Override
	public Supplier save(Supplier supplier) {
		
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
	
		Supplier supplierData = new Supplier();
		
		supplierData.setSupplierId(supplier.getSupplierId());
		supplierData.setSupplierEmail(supplier.getSupplierEmail());
		supplierData.setSupplierAddress(supplier.getSupplierAddress());
		supplierData.setSupplierName(supplier.getSupplierName());
		supplierData.setSupplierPhone(supplier.getSupplierPhone());
		supplierData.setSupplierPincode(supplier.getSupplierPincode());

		
		
		 session.save(supplierData);
         tx.commit();
		
		return supplierData;
		
	}

	//@Override
	
public List<Supplier> list(int offset, int limit) {
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createSQLQuery("select * from Supplier");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		
		System.out.println(limit + " " + offset);
		@SuppressWarnings("unchecked")
		
		List<Object[]> obj = query.getResultList();
	
		List<Supplier> suppliers = new ArrayList<>();
		
		for(Object[] o : obj) {
			
			Supplier supplier = new Supplier();
			
			supplier.setSupplierId((int) o[0]);
			supplier.setSupplierName((String) o[3]);
			supplier.setSupplierPhone((String) o[4]);
			supplier.setSupplierEmail((String) o[2]);
			supplier.setSupplierAddress((String) o[1]);
			supplier.setSupplierPincode((String) o[5]);
			
			suppliers.add(supplier);
			
		}
		
		tx.commit();
		
		return suppliers;
		
		
	}



}
