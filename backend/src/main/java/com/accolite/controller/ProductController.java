package com.accolite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Product;
import com.accolite.model.ProductDetails;
import com.accolite.service.ProductService;


@RestController
public class ProductController {
	
	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createproduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<Product> createProdict(@RequestBody ProductDetails product) throws Exception {
		System.out.println("Product: "+ product);
		Product response = ProductService.createProduct(product);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	


	@CrossOrigin
	@RequestMapping(value = "/getproducts", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<List<Product>> getProduct(@RequestParam(name = "offset")  int offset, @RequestParam(name = "limit") int limit) throws Exception {
		List<Product> response = ProductService.getProducts(offset, limit);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
}

}


