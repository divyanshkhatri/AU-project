package com.accolite.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="OrderProduct")
public class OrderProduct {
	
	@JoinColumn(name = "orderId")
	@ManyToOne(targetEntity = CustomerOrder.class, fetch = FetchType.LAZY)
	private CustomerOrder customerOrder;
	
	private int productQuantity;
	
	@JoinColumn(name = "productId")
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	private Product product;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderProductId;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder =customerOrder;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
		
}
