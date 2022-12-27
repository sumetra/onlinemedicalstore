package com.sumitra.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.stringtemplate.v4.compiler.STParser.includeExpr_return;

import com.sumitra.model.CartModel;
import com.sumitra.model.CategoryModel;
import com.sumitra.model.UserModel;
import com.sumitra.service.CartService;
import com.sumitra.service.ProductService;
import com.sumitra.service.UserService;


@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value = "/user/cart/add",method = RequestMethod.POST )
	public String insertCart(@RequestParam("pId") Integer pId,@RequestParam("pQuantity") Integer pQuantity,Principal principal)
			 {
		
		CartModel cartModel = new CartModel();
		cartModel.setProduct(productService.displayById(pId));
		
		cartModel.setQuantity(pQuantity);
		cartModel.setDate(LocalDate.now());
		System.out.println(principal.getName());
		cartModel.setUser(userService.geUserByUsername(principal.getName()));
		cartService.insert(cartModel);
		return "redirect:/user/cart/display";
	}
	
	@RequestMapping(value = "/user/cart/display",method = RequestMethod.GET)
	public String displayCart(Model model,Principal principal) {
//		UserModel userModel = userService.geUserByUsername(principal.getName());
//		System.out.println(userModel.getuName());
//		List<CartModel> cartList =  cartService.displaybyUser(userModel);
		List<CartModel> cartList =  userService.getUserCart(principal.getName());
		System.out.println("cart list received");
	model.addAttribute("clist",cartList);
	System.out.println("cart list added");
	return "frontend/cartdisplay";
	
	}
	
	@RequestMapping(value = "/user/cart/delete/{id}",method = RequestMethod.GET )
	public String deleteCart(@PathVariable("id") int id) {
		cartService.delete(id);
	return "redirect:/user/cart/display";
	}
	
	@RequestMapping(value = "/user/cart/update/{id}",method = RequestMethod.GET )
	public String updateCart(@PathVariable("id") int id,Model model) {
		cartService.displayById(id);
		model.addAttribute("cart", cartService.displayById(id));
	return "frontend/cartupdate";
	}
	
	@RequestMapping(value = "/user/cart/update",method = RequestMethod.POST )
	public String updateCart(@RequestParam("cartId") Integer cartId,@RequestParam("pQuantity") Integer pQuantity)
	{
	
		
	CartModel cartModel = cartService.displayById(cartId);
	cartModel.setQuantity(pQuantity);
	
	cartService.update(cartModel);
	return "redirect:/user/cart/display";
	
}
	
}
