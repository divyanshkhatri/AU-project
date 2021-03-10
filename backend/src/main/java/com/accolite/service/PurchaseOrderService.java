package com.accolite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accolite.dao.impl.OrderProductDAOImpl;
import com.accolite.dao.impl.PurchaseOrderDAOImpl;
import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;
import com.accolite.model.Purchase;
import com.accolite.model.PurchaseOrder;
import com.accolite.model.PurchaseOrderDetails;

@Service
public class PurchaseOrderService {
	
	public static PurchaseOrder createPurchase(Purchase purchase) {
		
		PurchaseOrderDAOImpl pruchaseOrderImpl = new PurchaseOrderDAOImpl();
		
		PurchaseOrder purchaseOrder = pruchaseOrderImpl.save(purchase);
		
		return purchaseOrder;
		
	}
	
	public static List<PurchaseOrderDetails> getPurchases(int supplierId) {
		
		PurchaseOrderDAOImpl purchaseOrderImpl = new PurchaseOrderDAOImpl();
		
		List<PurchaseOrderDetails> purchaseOrders = purchaseOrderImpl.getPurchases(supplierId);
		
		return purchaseOrders;
		
	}


}
