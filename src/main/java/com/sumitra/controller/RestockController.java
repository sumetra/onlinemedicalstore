package com.sumitra.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumitra.model.ProductModel;
import com.sumitra.model.RestockModel;
import com.sumitra.service.ProductService;
import com.sumitra.service.RestockService;

@Controller
public class RestockController {
	@Autowired
	RestockService restockService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/admin/restock_form",method = RequestMethod.GET )
	public String openRestock(Model model) {
		
		
		model.addAttribute("clist", restockService.display());
		model.addAttribute("rid", productService.display());
		
		return "admin/restock_form";
	}
	@RequestMapping(value = "/admin/restock_form",method = RequestMethod.POST )
	public String insertRestock(@RequestParam("pId") int pId,@RequestParam("rQuantity") String rQuantity,@RequestParam("rDate") String rDate,
			@RequestParam("rPrice") Double rPrice)
			 {
		
		RestockModel restockModel = new RestockModel(rQuantity,rPrice);
		restockModel.setrDate(LocalDate.parse(rDate));
		
		ProductModel productModel = productService.displayById(pId);
		productModel.setpQuantity(String.valueOf(Integer.parseInt(productModel.getpQuantity()) + Integer.parseInt(rQuantity)) );
		productService.update(productModel);
		restockModel.setProduct(productModel);
		restockService.insert(restockModel);
		return "redirect:/admin/restock_display";
	}
	
	@RequestMapping(value = "/admin/restock_delete/{id}",method = RequestMethod.GET )
	public String deleteRestock(@PathVariable("id") int id) {
	restockService.delete(id);
	return "redirect:/admin/restock_form";
	}
	
	@RequestMapping(value = "/admin/restock_update/{id}",method = RequestMethod.GET )
	public String updateRestock(@PathVariable("id") int id,Model model) {
		restockService.displayById(id);
		model.addAttribute("rproduct", restockService.displayById(id));
		model.addAttribute("product_list",productService.display());
	return "admin/restock_update";
	}
	
@RequestMapping(value = "/admin/restock_update/{id}" ,method = RequestMethod.POST )
	public String updateRestock(@RequestParam("rId") Integer rId,@RequestParam("pId") Integer pId,@RequestParam("rQuantity") String rQuantity,@RequestParam("rPrice") Double rPrice,
			@RequestParam("rDate") String rDate)
			{
		
		RestockModel restockModel = new RestockModel(rId,productService.displayById(pId),rQuantity,LocalDate.parse(rDate),rPrice);
		
		restockService.update(restockModel);
		return "redirect:/admin/restock_display";
			}
	
	@RequestMapping(value = "/admin/restock_display",method = RequestMethod.GET )
	public String displayRestock(Model model) {
		model.addAttribute("clist", restockService.display());
		
		return "admin/restock_display";
	}
}