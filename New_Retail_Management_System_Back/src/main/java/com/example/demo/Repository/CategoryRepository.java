package com.example.demo.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Category;

@Repository("catRepo")
public class CategoryRepository {
	List<Category>list;
	@Autowired
	JdbcTemplate jdbctemplate;
	

	public boolean isAddNewCategory(Category category)
	{
		int value =jdbctemplate.update("insert into Categories values('0',?)",new PreparedStatementSetter()
				{

					public void setValues(PreparedStatement ps) throws SQLException {
						
						ps.setString(1, category.getCategoryName());
						
					}
				
				});
		return value>0?true:false;
				
	}
	public List<Category> getAllCategories(){ 
		list =jdbctemplate.query("select *from  Categories", new RowMapper<Category>()
	{
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Category cat = new Category();
			cat.setCategoryID(rs.getInt("CategoryID"));
			cat.setCategoryName(rs.getString(" CategoryName"));
	           
			
			return cat;
		}
	});
		return list;
	}

}
