package com.accolite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.PurchaseProduct;
import com.accolite.model.PurchaseProductDetails;
import com.accolite.model.UpdatePurchaseStatus;
import com.accolite.service.PurchaseProductService;

@RestController
public class PurchaseProductController {
	
	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createpurchaseproduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<PurchaseProduct> createPurchaseProduct(@RequestBody PurchaseProductDetails purchaseProduct) throws Exception {
		//System.out.println("Order: "+ order);
		PurchaseProduct response = PurchaseProductService.createPurchaseProduct(purchaseProduct);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/getpurchaseproducts/{purchaseId}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<List<PurchaseProductDetails>> createPurchaseProduct(@PathVariable(name = "purchaseId") int purchaseId) throws Exception {
		//System.out.println("Order: "+ order);
		List<PurchaseProductDetails> response = PurchaseProductService.getProducts(purchaseId);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/updateproductstatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<String> updateproductstatus(@RequestBody UpdatePurchaseStatus updatePurchaseStatus) throws Exception {
		//System.out.println("Order: "+ order);
		String response = PurchaseProductService.updatePurchaseStatus(updatePurchaseStatus);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	

}