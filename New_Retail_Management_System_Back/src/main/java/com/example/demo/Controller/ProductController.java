package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.UserNotFoundException;


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
	@GetMapping("/searchproduct/{id}")
	 public Product searchUserById(@PathVariable int id) {
		Product pro = proservice.searchproductById(id);

	     if (pro != null) {
	         return pro;
	     } else {
	         throw new UserNotFoundException("product with ID " + id + " not found.");
	     }
	 }
	 @DeleteMapping("/deleteproduct/{id}")
	 public Product deletehProductById(@PathVariable int id) {
	     Product product = proservice.deletehProductById(id);

	     if (product != null) {
	        
	         return product ;
	     } else {
	         throw new UserNotFoundException("product with ID " + id + " not found.");
	     }
	 }

	 @PutMapping("/updateproduct/{id}")
	 public Product updateProductById(@PathVariable int id, @RequestBody Product updatedProduct) {
		 Product pro= proservice.updateProductById(id, updatedProduct);

	     if (pro != null) {
	         return pro; 
	     } else {
	         throw new UserNotFoundException("updatedProduct with ID " + id + " not found.");
	     }
	 }
	


	
}
