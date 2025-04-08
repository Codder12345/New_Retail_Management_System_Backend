package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;


public class CategoryController {
	@Autowired
	CategoryService catservice;
	@PostMapping("/addCategory") 
	public String createEmployee(@RequestBody Category category)
	{
		boolean b =catservice.isAddNewCategory(category);
		if(b)
		{
			return "Category Added";
		}
		  return "Category Not Added";
	}
	
	@GetMapping("/viewAllCategory")
	public List<Category> getAllCategories()
	{
		List <Category> list= catservice.getAllCategories();
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			throw new CategoryNotFoundException("there is No data in Database table");
		}
		
		
	}
	
}





