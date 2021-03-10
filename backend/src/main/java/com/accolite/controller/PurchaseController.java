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

import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;
import com.accolite.model.Purchase;
import com.accolite.model.PurchaseOrder;
import com.accolite.model.PurchaseOrderDetails;
import com.accolite.service.CustomerOrderService;
import com.accolite.service.PurchaseOrderService;

@RestController
public class PurchaseController {

	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createpurchase", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<PurchaseOrder> createOrder(@RequestBody Purchase purchase) throws Exception {
		PurchaseOrder response = PurchaseOrderService.createPurchase(purchase);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/getpurchases/{supplierId}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<List<PurchaseOrderDetails>> createOrder(@PathVariable(name = "supplierId") int supplierId) throws Exception {
		List<PurchaseOrderDetails> response = PurchaseOrderService.getPurchases(supplierId);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
}