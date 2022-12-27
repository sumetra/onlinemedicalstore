package com.sumitra.dao;

import java.util.List;

import com.sumitra.model.CategoryModel;

public interface CategoryDao {
	public void insert(CategoryModel categoryModel) ;
	public List<CategoryModel> display();
	public void delete(int id);
	public void update(CategoryModel categoryModel);
	public CategoryModel displayById(int id);
	public List<CategoryModel> displayForMenu();
	

}
