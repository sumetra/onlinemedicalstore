package com.sumitra.dao;

import java.util.List;


import com.sumitra.model.OrderModel;
import com.sumitra.model.UserModel;

public interface OrderDao {

	public void insert(OrderModel orderModel) ;
	public List<OrderModel> display();
	public void delete(int id);
	public void update(OrderModel orderModel);
	public OrderModel displayById(int id);
	public List<OrderModel> selectByUser(UserModel user);
	public List< OrderModel> displayByDate(String date);
	
}
