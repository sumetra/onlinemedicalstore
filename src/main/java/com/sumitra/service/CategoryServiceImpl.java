package com.sumitra.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.CategoryDao;
import com.sumitra.model.CategoryModel;
import com.sumitra.model.ProductModel;


@Service
public class CategoryServiceImpl implements CategoryService{
	
    @Autowired
    CategoryDao categoryDao;
	
	public void insert(CategoryModel categoryModel) {
		categoryDao.insert(categoryModel);
		
	}

	public List<CategoryModel> display() {
		// TODO Auto-generated method stub
		return categoryDao.display();
	}

	public void delete(int id) {
		categoryDao.delete(id);
		
	}

	public void update(CategoryModel categoryModel) {
		categoryDao.update(categoryModel);
		
	}

	public CategoryModel displayById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.displayById(id);
	}

	public Map<CategoryModel, List<ProductModel>> getCategoryWiseProduct() {
		Map<CategoryModel, List<ProductModel>> catProductListMap = new  HashMap<CategoryModel, List<ProductModel>> ();
		List<CategoryModel> catList = categoryDao.displayForMenu();
		
		for(CategoryModel cat : catList) {
			//System.out.println(cat.getCTitle() );
			//for(ProductModel pm: cat.getProductsList()) {
			//	System.out.println(pm.getpId());
			//}
//		System.out.println();
				catProductListMap.put(cat, cat.getProductsList());
//		System.out.println();
		}
		return catProductListMap;
	}

	

}
