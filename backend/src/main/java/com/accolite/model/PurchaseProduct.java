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
@Table(name="PurchaseProduct")
public class PurchaseProduct {
	
	@JoinColumn(name = "purchaseId")
	@ManyToOne(targetEntity = PurchaseOrder.class, fetch = FetchType.LAZY)
	private PurchaseOrder purchaseOrder;
	
    private int productQuantity;
	
	@JoinColumn(name = "productId")
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	private Product product;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int purchaseProductId;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
}

