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

import com.example.demo.Model.Product;
import com.example.demo.Model.User;

@Repository("proRepo")
public class ProductRepository {
	List<Product>list;
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public boolean isAddNewProduct(Product product)
	{
		int value =jdbctemplate.update("insert into products values('0',?,?,?,?,?,?)",new PreparedStatementSetter()
				{

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						
						ps.setString(1, product.getProductName());
						 ps.setInt(2, product.getProductPrice());
					        ps.setInt(3, product.getCategoryID());
					        ps.setString(4, product.getPBrand());
					        ps.setInt(5, product.getStockQuantity());
					        ps.setString(6, product.getImageUrl());
					}
				
				});
		return value>0?true:false;
				
	}
	public List<Product> getAllProducts(){ 
		list =jdbctemplate.query("select *from products", new RowMapper<Product>()
	{
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Product pro = new Product();
			   pro.setProductID(rs.getInt("ProductID"));
	            pro.setProductName(rs.getString("ProductName"));
	            pro.setProductPrice(rs.getInt("ProductPrice"));
	            pro.setCategoryID(rs.getInt("CategoryID"));
	            pro.setPBrand(rs.getString("PBrand"));
	            pro.setStockQuantity(rs.getInt("StockQuantity"));
	            pro.setImageUrl(rs.getString("ImageUrl"));
			
			return pro;
		}
	});
		return list;
	}
	public Product searchProductById(int id) {
 list = jdbctemplate.query("select * from  Products where ProductID = ?",new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setInt(1, id);
	            }
	        },
	        new RowMapper<Product>() {
	            @Override
	            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Product pro = new Product();
	                pro.setProductID(rs.getInt("ProductID"));
	                pro.setProductName(rs.getString("ProductName"));
	                pro.setProductPrice(rs.getInt("ProductPrice"));
	                pro.setCategoryID(rs.getInt("CategoryID"));
	                pro.setPBrand(rs.getString("PBrand"));
	                pro.setStockQuantity(rs.getInt("StockQuantity"));
	                pro.setImageUrl(rs.getString("ImageUrl"));
	                return pro;
	            }
	        }
	    );

	   
	    if (list.size() > 0) {
	        return list.get(0);
	    } else {
	        return null;
	    }
	}
	 public Product deletehProductById(int id) {
		 
		 
list = jdbctemplate.query( "select * from Products where ProductID = ?",
	                  new PreparedStatementSetter() {
	                      @Override
	                      public void setValues(PreparedStatement ps) throws SQLException {
	                          ps.setInt(1, id);
	                      }
	                  },
	                  new RowMapper<Product>() {
	                      @Override
	                      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    	  Product pro = new Product();
	      	                pro.setProductID(rs.getInt("ProductID"));
	      	                pro.setProductName(rs.getString("ProductName"));
	      	                pro.setProductPrice(rs.getInt("ProductPrice"));
	      	                pro.setCategoryID(rs.getInt("CategoryID"));
	      	                pro.setPBrand(rs.getString("PBrand"));
	      	                pro.setStockQuantity(rs.getInt("StockQuantity"));
	      	                pro.setImageUrl(rs.getString("ImageUrl"));
	      	                return pro;
	                      }
	                  }
	              );

	             
	              if (!list.isEmpty()) {
	                  jdbctemplate.update(  "delete from  Products where  ProductID = ?",new PreparedStatementSetter() {
	                          @Override
	                          public void setValues(PreparedStatement ps) throws SQLException {
	                              ps.setInt(1, id);
	                          }
	                      }
	                  );

	                  return list.get(0);
	              } else {
	                  return null; 
	          }


}
	 public Product updateProductById(int id, Product updatedProduct) {

		    int value = jdbctemplate.update(
		        "update Products SET ProductName = ?, ProductPrice = ?, CategoryID = ?, PBrand = ?, StockQuantity = ?, ImageUrl = ? WHERE ProductID = ?",
		        new PreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement ps) throws SQLException {
		                ps.setString(1, updatedProduct.getProductName());
		                ps.setInt(2, updatedProduct.getProductPrice());
		                ps.setInt(3, updatedProduct.getCategoryID());
		                ps.setString(4, updatedProduct.getPBrand());
		                ps.setInt(5, updatedProduct.getStockQuantity());
		                ps.setString(6, updatedProduct.getImageUrl());
		                ps.setInt(7, id);
		            }
		        }
		    );

		    if (value > 0) {
		        updatedProduct.setProductID(id);  
		        return updatedProduct;
		    } else {
		        return null;
		    }

		}

		}

