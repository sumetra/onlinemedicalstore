package com.sumitra.service;

import java.util.List;

import com.sumitra.model.CartModel;
import com.sumitra.model.UserModel;

public interface CartService {
	public void insert(CartModel cartModel) ;
	public List<CartModel> display();
	public void delete(int id);
	public void deleteCarts( List<Integer> ids);
	public void update(CartModel cartModel);
	public CartModel displayById(int id);
	public List<CartModel> displaybyUser(UserModel userModel);

	

}
