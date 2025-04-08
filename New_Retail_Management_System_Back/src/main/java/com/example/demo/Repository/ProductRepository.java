package com.example.demo.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Product;

@Repository("proRepo")
public class ProductRepository {
	List<Product>list;
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public boolean isAddNewProdu(Product employee)
	{
		int value =jdbctemplate.update("insert into employee value('0',?,?,?)",new PreparedStatementSetter()
				{

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
					
						
					}
				
				});
		return value>0?true:false;
				
	}
	public List<Product> getAllProdus(){ 
		list =jdbctemplate.query("select *from employee", new RowMapper<Product>()
	{
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Product emp = new Product();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setEmail(rs.getString(3));
			emp.setContact(rs.getString(4));
			return emp;
		}
	});
		return list;
	}

}
