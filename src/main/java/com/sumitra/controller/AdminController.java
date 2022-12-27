package com.sumitra.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumitra.model.AdminStatsDTO;
import com.sumitra.model.UserModel;
import com.sumitra.service.OrderService;
import com.sumitra.service.ProductService;
import com.sumitra.service.UserService;


@Controller
public class AdminController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/admin/home",method=RequestMethod.GET)
	public String openHome(Model model, Principal p) {
		UserModel uModel = userService.geUserByUsername(p.getName());
		
		AdminStatsDTO adminStats = new AdminStatsDTO();
		adminStats.setNo_of_orders(orderService.orderStats());
		adminStats.setNo_of_prodouts(23);
		adminStats.setNo_of_users(userService.getUserCount());
		
		model.addAttribute("user", uModel);
		model.addAttribute("admin_stats", adminStats);
		
		return "admin/index";
	}

		
	
	@RequestMapping(value = "/admin/user_form",method = RequestMethod.GET )
	public String openCategory(Model model) {
		model.addAttribute("ulist", userService.display());
		
	return "admin/user_form";
	}
	
	@RequestMapping(value = "/admin/user_form",method = RequestMethod.POST )
	public String insertUser(@RequestParam("uName") String uName,@RequestParam("uPassword") String uPassword,
			@RequestParam("uEmail") String uEmail,@RequestParam("uAddress") String uAddress,
			@RequestParam("uPhone") String uPhone,@RequestParam("uActive") String uActive) {
		
		
		UserModel userModel = new UserModel(0,uName,uPassword,uEmail,uAddress,uPhone,uActive);
		userModel.setRegDate(LocalDate.now());
		userService.insert(userModel);
		return "redirect:/admin/user_form";
	}
	
	@RequestMapping(value = "/admin/user_delete/{id}",method = RequestMethod.GET )
	public String deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
	return "redirect:/admin/user_form";
	}
	
	@RequestMapping(value = "/admin/user_update/{id}",method = RequestMethod.GET )
	public String updateUser(@PathVariable("id") int id,Model model) {
		userService.displayById(id);
		model.addAttribute("uName", userService.displayById(id));
	return "admin/user_update";
	}
	
	@RequestMapping(value = "/admin/user_update/{id}" ,method = RequestMethod.POST )
	public String updateUser(@RequestParam("uId") Integer uId,@RequestParam("uName") String uName,@RequestParam("uPassword") String uPassword,
			@RequestParam("uEmail") String uEmail,@RequestParam("uAddress") String uAddress,
			@RequestParam("uPhone") String uPhone,@RequestParam("uActive") String uActive)
			{
		
		UserModel userModel = new UserModel(uId,uName,uPassword,uEmail,uAddress,uPhone,uActive);
		userService.update(userModel);
		return "redirect:/admin/user_form";
	}
	@RequestMapping(value = "/admin/user_display",method = RequestMethod.GET )
	public String displayUser(Model model) {
		model.addAttribute("ulist", userService.display());
		
		return "admin/user_display";
	}
	
	
	
}
