package com.sumitra.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumitra.dao.OrderDao;
import com.sumitra.model.CartModel;
import com.sumitra.model.OrderModel;
import com.sumitra.model.ProductModel;
import com.sumitra.model.UserModel;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	public void insert(OrderModel orderModel) {
		orderDao.insert(orderModel);

	}

	public void addOrderFromCart(List<CartModel> cartList) {
		
		// assemble cart into order
		
		for(CartModel cModel : cartList) {
		
			OrderModel orderModel = new OrderModel();
			orderModel.setProducts(cModel.getProduct());
			orderModel.setQuantity(cModel.getQuantity());
			orderModel.setUser(cModel.getUser());
			
			orderModel.setDate(LocalDate.now());
			orderModel.setStatus("Not Processed");
			orderModel.setOrderId("ORDER_"+cartList.get(0).getCartId()); 
			
			orderDao.insert(orderModel);
		}
		
	}

	public List<OrderModel> display() {
		return orderDao.display();
	}

	public void delete(int id) {
		orderDao.delete(id);
	}

	public void update(OrderModel orderModel) {
		orderDao.update(orderModel);

	}

	public OrderModel displayById(int id) {
		return orderDao.displayById(id);
	}

	public List<OrderModel> getOrderByUser(UserModel user) {
		
		return orderDao.selectByUser(user);
	}

	public List<OrderModel> displayByDate(String date) {
		// TODO Auto-generated method stub
		return orderDao.displayByDate(date) ;
	}

	public int orderStats() {
		List<OrderModel> ordersList = orderDao.displayByDate(LocalDate.now().toString());
		return ordersList.size();
	}

}
