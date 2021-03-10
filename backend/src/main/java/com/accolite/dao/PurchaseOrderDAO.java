package com.accolite.dao;

import java.util.List;

import com.accolite.model.Purchase;
import com.accolite.model.PurchaseOrder;
import com.accolite.model.PurchaseOrderDetails;

public interface PurchaseOrderDAO {
	
	PurchaseOrder save(Purchase purchase);
	
	List<PurchaseOrderDetails> getPurchases(int supplierId);

}
