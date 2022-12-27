package com.sumitra.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumitra.model.CartModel;
import com.sumitra.model.NotificationModel;
import com.sumitra.model.OrderModel;
import com.sumitra.model.UserModel;
import com.sumitra.service.CartService;
import com.sumitra.service.NotificationService;
import com.sumitra.service.OrderService;
import com.sumitra.service.UserService;

@Controller
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	NotificationService notificationService;
	
	static String[] orderStatus = {"Not Processed","Processing","Processed","Delivered", "Cancelled"};

	@GetMapping("/user/order/show")
	public String showOrder(Model model,Principal p) {
		UserModel userModel = userService.geUserByUsername(p.getName());
		
		System.out.println(userModel.getuName());
		List<OrderModel> orderList = orderService.getOrderByUser(userModel);
		for(OrderModel orderModel : orderList) {
			System.out.print(orderModel.getOrderId());
		}
		model.addAttribute("orderStatus", orderStatus);
		model.addAttribute("order_list", orderList);
		return "/frontend/orderdisplay";
	}
	
	@GetMapping("/admin/order_display")
	public String showOrder(Model model) {
		model.addAttribute("orderStatus", orderStatus);
		model.addAttribute("view", orderService.display());
		return "/admin/order_display";
	}
	
	
	@PostMapping("/admin/order/update/{oid}")
	public String updateOrder(@PathVariable("oid") int order_id, @RequestParam("status") String status) {
		OrderModel om = orderService.displayById(order_id);
		if(om==null) {
			return "redirect:/admin/order_display?invalid_id=true";
		}
		om.setStatus(status);
		orderService.update(om);
		// send user a notification
		 NotificationModel notification = new NotificationModel();
		 notification.setUserModel(om.getUser());
		 notification.setNotice("Product status changed to "+status+" of order "+ om.getOrderId());
		 notification.setViewed("false");
		 notification.setDate(LocalDate.now());
		 notificationService.insert(notification);
		
		return "redirect:/admin/order_display";
	}
	
	
	
	@GetMapping("/user/order/add") 
		public String addOrder (@RequestParam(required = false) List<Integer> carts  ) {
		if(carts==null) {
			return "redirect:/user/cart/display?cart_item_not_selected";
		}
		
		List<CartModel> cartList = new ArrayList<CartModel>();
		for(int cid : carts) {
			cartList.add(cartService.displayById(cid));
		}
		orderService.addOrderFromCart(cartList);
		
		cartService.deleteCarts(carts);   // delete cart info after adding products form cart into order
		
		
		return "redirect:/user/order/show";
		}
	
		@GetMapping("/admin/search")
		public String search(@RequestParam("date")String date,Model model)
		{
			model.addAttribute("orderStatus", orderStatus);
			model.addAttribute("view", orderService.displayByDate(date));
			return "admin/order_display" ;
		}

}
