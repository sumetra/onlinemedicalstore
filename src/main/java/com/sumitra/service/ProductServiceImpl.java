package com.sumitra.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.ProductDao;

import com.sumitra.model.ProductModel;

@Service
public class ProductServiceImpl implements ProductService{
	
    @Autowired
    ProductDao productDao;
    
    
	
	public void insert(ProductModel productModel) {
		productDao.insert(productModel);
		
	}

	public List<ProductModel> display() {
		return productDao.display();
	}

	public void delete(int id) {
		productDao.delete(id);
		
	}

	public void update(ProductModel productModel) {
		
		productDao.update(productModel);
		
	}

	public ProductModel displayById(int id) {
		return productDao.displayById(id);
	}

	public Map<String, List<ProductModel>> getCategoryWiseProduct() {
	//	Map<String, List<ProductModel>> catProducts = new HashMap<String, List<ProductModel>>();   // to place prodeuct category wise to be display as a menu
	//	List<ProductModel> productList = productDao.display();  // fetches all products
	//	// device all products category wise
		
	return null;	
		
	
	}

	public List<ProductModel>  search(ProductModel productModel ) {
		// TODO Auto-generated method stub
		return productDao.search(productModel);
	}
	
	

	

}
