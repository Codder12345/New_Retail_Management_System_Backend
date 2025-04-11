package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.ProductRepository;
@Service("proservice")
public class ProductService {

	@Autowired
	private ProductRepository proRepo;
	
	public boolean isAddNewProduct(Product product)
	{
		return proRepo.isAddNewProduct(product);
    }
	public List<Product> getAllProducts()
	{
		return proRepo.getAllProducts();
		
	}
	public Product searchproductById(int id)
	{
		return proRepo.searchProductById(id);
	}
	
	public Product deletehProductById(int id)
	{
		return proRepo.deletehProductById(id);
	}
	
	public Product updateProductById(int id ,Product updatedProduct)
	{
		return proRepo.updateProductById(id, updatedProduct);
	}
}
