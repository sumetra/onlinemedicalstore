package com.sumitra.service;

import java.time.LocalDate;
import java.util.List;

import com.sumitra.model.AdminStatsDTO;
import com.sumitra.model.CartModel;
import com.sumitra.model.OrderModel;
import com.sumitra.model.UserModel;



public interface OrderService {
	
	public void insert(OrderModel orderModel) ;
	
	public void addOrderFromCart(List<CartModel> cartList);
	public List<OrderModel> display();
	public void delete(int id);
	public void update(OrderModel orderModel);
	public OrderModel displayById(int id);

	public List<OrderModel> getOrderByUser(UserModel user);
	public List<OrderModel> displayByDate(String date);

	public int orderStats();

	

}
