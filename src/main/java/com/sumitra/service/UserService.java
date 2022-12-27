package com.sumitra.service;

import java.util.List;

import com.sumitra.model.CartModel;
import com.sumitra.model.UserModel;



public interface UserService {
	public void insert(UserModel userModel) ;
	public List<UserModel> display();
	public void delete(int id);
	public void update(UserModel userModel);
	public UserModel displayById(int id);
	public UserModel geUserByUsername(String uName);
	public List<CartModel> getUserCart(String uName);
	public int getUserCount();

}
