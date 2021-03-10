package com.accolite.dao;

import java.util.List;

import com.accolite.model.PurchaseProduct;
import com.accolite.model.PurchaseProductDetails;
import com.accolite.model.UpdatePurchaseStatus;

public interface PurchaseProductDAO {

	PurchaseProduct save(PurchaseProductDetails purchaseProductDetails);
	
	String updatePurchaseStatus(UpdatePurchaseStatus updatePurchaseStatus);
	
	List<PurchaseProductDetails> getProducts(int purchaseId);
	
}
