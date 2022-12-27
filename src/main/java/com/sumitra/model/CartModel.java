package com.sumitra.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_table")
public class CartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private ProductModel product;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private UserModel user;
	
	private LocalDate date;
	private Integer quantity;
	
	 
	public CartModel() {
		super();
	}
	public CartModel(Integer cartId, ProductModel product, UserModel user, LocalDate date, Integer quantity) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.user = user;
		this.date = date;
		this.quantity = quantity;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	
}


