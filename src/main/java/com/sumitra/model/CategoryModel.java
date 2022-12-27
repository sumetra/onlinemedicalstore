package com.sumitra.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Category")
public class CategoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer cId;
	private String cTitle;
	private String cDescription;
	
	@OneToMany(mappedBy = "category")
	private List<ProductModel> productsList;
	
	 
	
	
	public CategoryModel() {
		super();
		
	}

	public CategoryModel( String cTitle, String cDescription) {
		super();
		this.cTitle = cTitle;
		this.cDescription = cDescription;
	}

	public CategoryModel(Integer cId, String cTitle, String cDescription) {
		super();
		this.cId = cId;
		this.cTitle = cTitle;
		this.cDescription = cDescription;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getCTitle() {
		return cTitle;
	}

	public void setCTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public List<ProductModel> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<ProductModel> productsList) {
		this.productsList = productsList;
	}


	
	
	

	
}
