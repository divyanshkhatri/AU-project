package com.accolite.service;

import java.util.List;

import com.accolite.dao.impl.PurchaseProductDAOImpl;
import com.accolite.model.PurchaseProduct;
import com.accolite.model.PurchaseProductDetails;
import com.accolite.model.UpdatePurchaseStatus;

public class PurchaseProductService {
	
	public static PurchaseProduct createPurchaseProduct(PurchaseProductDetails purchaseProductDetails) {

		PurchaseProductDAOImpl purchaseProductImpl = new PurchaseProductDAOImpl();
		
		PurchaseProduct purchaseProductData = purchaseProductImpl.save(purchaseProductDetails);
		
		return purchaseProductData;
		
	}
	
	public static String updatePurchaseStatus(UpdatePurchaseStatus updatePurchaseStatus) {
		
		PurchaseProductDAOImpl purchaseProductImpl = new PurchaseProductDAOImpl();
		
		String updated = purchaseProductImpl.updatePurchaseStatus(updatePurchaseStatus);
		
		return updated;
		
	}
	
	public static List<PurchaseProductDetails> getProducts(int purchaseId) {
		
		PurchaseProductDAOImpl purchaseProductImpl = new PurchaseProductDAOImpl();
		
		List<PurchaseProductDetails> purchaseProductDetails = purchaseProductImpl.getProducts(purchaseId);
		
		return purchaseProductDetails;
		
	}

}
