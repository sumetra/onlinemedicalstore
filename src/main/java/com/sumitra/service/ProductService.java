package com.sumitra.service;

import java.util.List;
import java.util.Map;

import com.sumitra.model.ProductModel;


public interface ProductService {
	public void insert(ProductModel productModel) ;
	public List<ProductModel> display();
	public void delete(int id);
	public void update(ProductModel productModel);
	public ProductModel displayById(int id);
	public Map<String,List<ProductModel>> getCategoryWiseProduct();
	public List<ProductModel> search(ProductModel productModel);
}
		
	


