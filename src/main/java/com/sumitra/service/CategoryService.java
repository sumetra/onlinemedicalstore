package com.sumitra.service;

import java.util.List;
import java.util.Map;

import com.sumitra.model.CategoryModel;
import com.sumitra.model.ProductModel;

public interface CategoryService {
	public void insert(CategoryModel categoryModel) ;
	public List<CategoryModel> display();
	public void delete(int id);
	public void update(CategoryModel categoryModel);
	public CategoryModel displayById(int id);
	public Map<CategoryModel , List<ProductModel>> getCategoryWiseProduct();

	

}
