package com.sumitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumitra.model.CategoryModel;
import com.sumitra.service.CategoryService;



@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/admin/category_form",method = RequestMethod.GET )
	public String openCategory(Model model) {
		
		model.addAttribute("clist", categoryService.display());
	return "admin/category_form";
	}
	@RequestMapping(value = "/admin/category_form",method = RequestMethod.POST )
	public String insertCategory(@RequestParam("cTitle") String cTitle, @RequestParam("cDescription") String cDescription)
			{
		
		CategoryModel categoryModel = new CategoryModel(cTitle,cDescription);
		categoryService.insert(categoryModel);
		return "redirect:/admin/category_form";
	}
	
	@RequestMapping(value = "/admin/category_delete/{id}",method = RequestMethod.GET )
	public String deleteCategory(@PathVariable("id") int id) {
		categoryService.delete(id);
	return "redirect:/admin/category_form";
	}
	
	@RequestMapping(value = "/admin/category_update/{id}",method = RequestMethod.GET )
	public String updateCategory(@PathVariable("id") int id,Model model) {
		categoryService.displayById(id);
		model.addAttribute("cTitle", categoryService.displayById(id));
	return "admin/category_update";
	}
	
	@RequestMapping(value = "/admin/category_update/{id}" ,method = RequestMethod.POST )
	public String updateCategory(@RequestParam("cId") Integer cId,@RequestParam("cTitle") String cTitle, @RequestParam("cDescription") String cDescription)
			{
		
		CategoryModel categoryModel = new CategoryModel(cId,cTitle,cDescription);
		categoryService.update(categoryModel);
		return "redirect:/admin/category_form";
	}
	@RequestMapping(value = "/admin/category_display",method = RequestMethod.GET )
	public String displayCategory(Model model) {
		model.addAttribute("clist", categoryService.display());
		
		return "admin/category_display";
	
	

	}
	
//	@RequestMapping(value = "/",method = RequestMethod.GET )
//	public String displayCategoryFrontend(Model model) {
//		model.addAttribute("clist", categoryService.display());
//		
//		return "frontend/index";
//	
//	
//
//	}

}
