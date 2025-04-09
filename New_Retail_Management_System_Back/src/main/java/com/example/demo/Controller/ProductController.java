package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ProductNotFoundException;


@RestController
@RequestMapping("/api/product")
public class ProductController {

	
	@Autowired
	ProductService proservice;
	@PostMapping("/addProduct") 
	public String addProduct(@RequestBody Product product)
	{
		boolean b =proservice.isAddNewProduct(product);
		if(b)
		{
			return "product Added";
		}
		  return "product Not Added";
	}
	
	@GetMapping("/viewAllProduct")
	public List<Product> getAllProducts()
	{
		List <Product> list= proservice.getAllProducts();
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			throw new ProductNotFoundException("there is No data in Database table");
		}
		
		
	}
	

	
}
