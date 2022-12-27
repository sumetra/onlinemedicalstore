package com.sumitra.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.UserDao;
import com.sumitra.model.CartModel;
import com.sumitra.model.UserModel;
import com.sumitra.model.UserroleModel;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userDao;

	public void insert(UserModel userModel) {
		UserroleModel userroleModel=new UserroleModel();
		userroleModel.setrRole("ROLE_USER");
		userroleModel.setUserModel(userModel);
		userModel.setUserroleModel(userroleModel);
		
		userModel.setuActive("1");
		userDao.insert(userModel);
		
	}

	public List<UserModel> display() {
		
		return userDao.display();
	}

	public void delete(int id) {
		userDao.delete(id);
		
	}

	public void update(UserModel userModel) {
		userDao.update(userModel);
		
	}

	public UserModel displayById(int id) {
		
		return userDao.displayById(id);
	}

	public UserModel geUserByUsername(String uName) {
		
		return userDao.selectByUsername(uName);
	}

	public List<CartModel> getUserCart(String uName) {
		// TODO Auto-generated method stub
		return userDao.getUserCart(uName);
	}

	public int getUserCount() {
		List<UserModel> userList = userDao.displayByRegDate(LocalDate.now());
		
		return userList.size();
	}
	

}
