package com.accolite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CustomerOrder")
public class CustomerOrder {

	
	@JoinColumn(name = "customerId")
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Customer customer;
	
	@Column(name="orderStatus", columnDefinition="enum('NotConfirmed', 'Confirmed', 'Shipped', 'Completed', 'Cancelled')")
	private String orderStatus;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	private int orderProfit;
		
	
//	
//	@OneToMany(mappedBy = "customerOrder")
//	private List<OrderProduct> orderProducts;
	
	

	public Customer getCustomer() {
		return customer;
	}

	public int getOrderProfit() {
		return orderProfit;
	}

	public void setOrderProfit(int orderProfit) {
		this.orderProfit = orderProfit;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
		
}
