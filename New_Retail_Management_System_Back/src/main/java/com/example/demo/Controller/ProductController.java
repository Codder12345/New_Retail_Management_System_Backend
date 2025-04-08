package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ProductNotFoundException;

public class ProductController {

	
	@Autowired
	ProductService proservice;
	@PostMapping("/addProduct") 
	public String createEmployee(@RequestBody Product product)
	{
		boolean b =proservice.isAddNewProduct(product);
		if(b)
		{
			return "Employee Added";
		}
		  return "employee Not Added";
	}
	
	@GetMapping("/viewAllProduct")
	public List<Product> getAllEmployees()
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
