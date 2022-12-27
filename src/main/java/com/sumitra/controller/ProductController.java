package com.sumitra.controller;

import org.apache.lucene.analysis.phonetic.PhoneticFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sumitra.model.ProductModel;
import com.sumitra.service.CategoryService;
import com.sumitra.service.FileUploadService;
import com.sumitra.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping(value = "/admin/product_form",method = RequestMethod.GET )
	public String openProduct(Model model) {
		
		
		model.addAttribute("clist", productService.display());
		model.addAttribute("cid", categoryService.display());
		
		return "admin/product_form";
	}
	@RequestMapping(value = "/admin/product_form",method = RequestMethod.POST )
	public String insertProduct(@RequestParam("pMedicine") String pMedicine,@RequestParam("pName") String pName,@RequestParam("pDescription") String pDescription,
			@RequestParam("pPhoto") MultipartFile pPhoto,@RequestParam("pPrice") String pPrice,
			@RequestParam("pQuantity") String pQuantity,@RequestParam("cId") int cId) {
		
		ProductModel productModel = new ProductModel(pMedicine,pName,pDescription,pPhoto.getOriginalFilename(),pPrice,pQuantity);
		productModel.setCategory(categoryService.displayById(cId));
		Metaphone metaphone = new Metaphone();
		String pmed = metaphone.encode(pMedicine);
		String pname = metaphone.encode(pName);
		String search = pmed+pname;
		//System.out.println(search);
		productModel.setSearch(search);
		productService.insert(productModel);
		fileUploadService.uploadImage(pPhoto, "mediserveProduct");
		return "redirect:/admin/product_form";
	} 
	
	@RequestMapping(value = "/admin/product_delete/{id}",method = RequestMethod.GET )
	public String deleteProduct(@PathVariable("id") int id) {
		productService.delete(id);
	return "redirect:/admin/product_form";
	}
	
	@RequestMapping(value = "/admin/product_update/{id}",method = RequestMethod.GET )
	public String updateProduct(@PathVariable("id") int id,Model model) {
		productService.displayById(id);
		model.addAttribute("product", productService.displayById(id));
		model.addAttribute("category_list",categoryService.display());
	return "admin/product_update";
	}
	
	@RequestMapping(value = "/admin/product_update" ,method = RequestMethod.POST )
	public String updateProduct(@RequestParam("pId") Integer pId,@RequestParam("pMedicine") String pMedicine,@RequestParam("pName") String pName,@RequestParam("pDescription") String pDescription,
			@RequestParam(value="pPhoto", required = false)  MultipartFile pPhoto, @RequestParam("oldphoto")String oldphoto,@RequestParam("pPrice") String pPrice,
			@RequestParam("pQuantity") String pQuantity,@RequestParam("cId") int cId)
			{
		
		ProductModel productModel = new ProductModel(pId,pMedicine,pName,pDescription,oldphoto,pPrice,pQuantity, null);
		productModel.setCategory(categoryService.displayById(cId));
		
		if(! (pPhoto==null || pPhoto.getOriginalFilename().equals(oldphoto)) ) {
			fileUploadService.uploadImage(pPhoto, "mediserveProduct");  // upload only if user selects different image
			productModel.setpPhoto(pPhoto.getOriginalFilename());
		}
		productService.update(productModel);
		return "redirect:/admin/product_form";
	}
	@RequestMapping(value = "/admin/product_display",method = RequestMethod.GET )
	public String displayProduct(Model model) {
		model.addAttribute("clist", productService.display());
		
		return "admin/product_display";
	}
	
	
	
	@GetMapping("/product/detail/{id}")
	public String showProductdetail(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("prod",productService.displayById(id));
		
		
		
		return "frontend/productdetail";
		
	}
	
	
	
}