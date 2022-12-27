package com.sumitra.service;

import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.CartDao;
import com.sumitra.model.CartModel;
import com.sumitra.model.UserModel;



@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;

	public void insert(CartModel cartModel) {
		cartDao.insert(cartModel);
		
	}

	public List<CartModel> display() {
		// TODO Auto-generated method stub
		return cartDao.display();
	}

	public void delete(int id) {
		cartDao.delete(id);
		
	}

	public void update(CartModel cartModel) {
		cartDao.update(cartModel);
		
	}

	public CartModel displayById(int id) {
		// TODO Auto-generated method stub
		return cartDao.displayById(id);
	}

	public void deleteCarts( List<Integer> ids) {
		// TODO Auto-generated method stub
		 cartDao.deleteCarts(ids);
	}
	
	public List<CartModel> displaybyUser(UserModel user) {
		
		return cartDao.selectbyUser(user);
	}

	
	

}
