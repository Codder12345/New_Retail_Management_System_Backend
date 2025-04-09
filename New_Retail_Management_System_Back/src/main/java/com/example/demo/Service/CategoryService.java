package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.User;
import com.example.demo.Repository.CategoryRepository;



@Service("catservice")
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	public boolean isAddNewCategory(Category category)
	{
		return catRepo.isAddNewCategory(category);
    }
	
	
	public List<Category> getAllCategories() {
		
		return catRepo.getAllCategories();
	}
}


