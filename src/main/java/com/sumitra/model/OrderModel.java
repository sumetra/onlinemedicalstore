package com.sumitra.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//
@Entity
@Table(name = "order_table")
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	 private int oId;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private ProductModel products;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	 private UserModel user;
	
	@Column(name="order_id")
	private String orderId;
	
	private LocalDate date;
	private String shippingaddress;
	private String transaction;
	private String status;
	
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public OrderModel(int oId, ProductModel products,int quantity, UserModel user, String orderId, LocalDate date,
			String shippingaddress, String transaction, String status) {
		super();
		this.oId = oId;
		this.products = products;
		this.quantity = quantity;
		this.user = user;
		this.orderId = orderId;
		this.date = date;
		this.shippingaddress = shippingaddress;
		this.transaction = transaction;
		this.status = status;
	}



	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}


	public ProductModel getProducts() {
		return products;
	}



	public void setProducts(ProductModel products) {
		this.products = products;
	}

	

	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	

	
}
