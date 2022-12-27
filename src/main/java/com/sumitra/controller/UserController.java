package com.sumitra.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumitra.model.UserModel;
import com.sumitra.service.CartService;
import com.sumitra.service.NotificationService;
import com.sumitra.service.OrderService;
import com.sumitra.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/user/profile")
	public String userHome(Model model, Principal p) {
		String username = p.getName();
		UserModel userDetail = userService.geUserByUsername(username);
		model.addAttribute("userdetail", userDetail);
		model.addAttribute("notification_list", notificationService.displaybyUser(userDetail));
		model.addAttribute("cart_list", cartService.displaybyUser(userDetail));
		model.addAttribute("order_list", orderService.getOrderByUser(userDetail));
		return "frontend/home";
	}
}
