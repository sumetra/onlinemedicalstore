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
@Table(name="Restock")
public class RestockModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
private Integer rId;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private ProductModel product;
	private String rQuantity;
	private LocalDate rDate;
	private Double rPrice;
	
	public RestockModel() {
		super();
		
	}

	public RestockModel(Integer rId, ProductModel product, String rQuantity, LocalDate rDate,Double rPrice) {
		super();
		this.rId = rId;
		this.product = product;
		this.rQuantity = rQuantity;
		this.rDate = rDate;
		this.rPrice=rPrice;
	}

	public RestockModel( String rQuantity,Double rPrice) {
		super();
		this.product = product;
		this.rQuantity = rQuantity;
		this.rDate = rDate;
		this.rPrice=rPrice;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public String getrQuantity() {
		return rQuantity;
	}

	public void setrQuantity(String rQuantity) {
		this.rQuantity = rQuantity;
	}

	public LocalDate getrDate() {
		return rDate;
	}

	public void setrDate(LocalDate rDate) {
		this.rDate = rDate;
	}
	
	public Double getrPrice() {
		return rPrice;
	}

	public void setrPrice(Double rPrice) {
		this.rPrice = rPrice;
	}
	
	
	
	
	

}
