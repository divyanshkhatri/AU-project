package com.accolite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;

	private String productName;
	
	private int productOnHand;
	
	private int productAvailable;
	
	private int productOutgoing;
	
	private int productIncoming;
	
	private int productcostPrice;
	
	private int productSellingPrice;
	
//	@OneToMany(mappedBy = "product")
//	List<OrderProduct> orderProduct;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductOnHand() {
		return productOnHand;
	}

	public void setProductOnHand(int productOnHand) {
		this.productOnHand = productOnHand;
	}

	public int getProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(int productAvailable) {
		this.productAvailable = productAvailable;
	}

	public int getProductOutgoing() {
		return productOutgoing;
	}

	public void setProductOutgoing(int productOutgoing) {
		this.productOutgoing = productOutgoing;
	}

	public int getProductIncoming() {
		return productIncoming;
	}

	public void setProductIncoming(int productIncoming) {
		this.productIncoming = productIncoming;
	}

	public int getProductcostPrice() {
		return productcostPrice;
	}

	public void setProductcostPrice(int productcostPrice) {
		this.productcostPrice = productcostPrice;
	}

	public int getProductSellingPrice() {
		return productSellingPrice;
	}

	public void setProductSellingPrice(int productSellingPrice) {
		this.productSellingPrice = productSellingPrice;
	}
	
}
