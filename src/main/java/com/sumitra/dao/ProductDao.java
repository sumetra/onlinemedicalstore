package com.sumitra.dao;

import java.util.List;
import java.util.Map;

import com.sumitra.model.ProductModel;

public interface ProductDao {
	public void insert(ProductModel productModel) ;
	public List<ProductModel> display();
	public void delete(int id);
	public void update(ProductModel productModel);
	public ProductModel displayById(int id);
	public List<ProductModel> search(ProductModel productModel );
	
	

}
