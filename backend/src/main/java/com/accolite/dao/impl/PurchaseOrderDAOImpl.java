package com.accolite.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.accolite.dao.PurchaseOrderDAO;
import com.accolite.model.Customer;
import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;
import com.accolite.model.Purchase;
import com.accolite.model.PurchaseOrder;
import com.accolite.model.PurchaseOrderDetails;
import com.accolite.model.Supplier;
import com.accolite.utils.Connection;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO{
	

	@Override
	public PurchaseOrder save(Purchase purchase) {
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		PurchaseOrder purchaseOrderData = new PurchaseOrder();
		
		int supplierId = purchase.getSupplierId();
		
		Query query = session.createSQLQuery("select * from Supplier WHERE supplierId = :id");
		query.setParameter("id", supplierId);
		
		
		@SuppressWarnings("unchecked")
		List<Object[]> obj = query.getResultList();
        Supplier supplier=new Supplier();

        
        supplier.setSupplierId((int)obj.get(0)[0]);
        supplier.setSupplierAddress((String)obj.get(0)[1]);
        supplier.setSupplierEmail((String)obj.get(0)[2]);
        supplier.setSupplierName((String)obj.get(0)[3]);
        supplier.setSupplierPhone((String)obj.get(0)[4]);
        supplier.setSupplierPincode((String)obj.get(0)[5]);
        
        purchaseOrderData.setSupplier(supplier);
        purchaseOrderData.setPurchaseStatus("Draft");
        purchaseOrderData.setPurchaseCost(0);

		session.save(purchaseOrderData);
		tx.commit();
		
		return purchaseOrderData;
	}

	@Override
	public List<PurchaseOrderDetails> getPurchases(int supplierId) {
		
		Session session = Connection.getSession();
		
		List<PurchaseOrder> supplierList = session.createCriteria(Supplier.class).add(Restrictions.eq("supplierId", supplierId)).list();
		
		
		List<PurchaseOrder> list = session.createCriteria(PurchaseOrder.class).add(Restrictions.eq("supplier", supplierList.get(0))).list();

		
		
//		@SuppressWarnings("unchecked")
//		List<Object[]> obj = query.getResultList();
		
		List<PurchaseOrderDetails> purchaseOrders = new ArrayList<>();
		
		for(int i = 0; i<list.size(); i++) {
		
	        PurchaseOrderDetails purchaseOrderDetails = new PurchaseOrderDetails();
	
	        purchaseOrderDetails.setSupplierId(list.get(i).getSupplier().getSupplierId());
	        purchaseOrderDetails.setPurchaseStatus(list.get(i).getPurchaseStatus());
	        purchaseOrderDetails.setPurchaseId(list.get(i).getPurchaseId());
	        
	        purchaseOrders.add(purchaseOrderDetails);
		
		}
		
        
		return purchaseOrders;
	}
	
	
	

}
