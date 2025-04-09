package com.example.demo.Model;

import lombok.Data;

@Data
public class Product {
	private int  productID;
    private String productName;
    private int productPrice;
    private int  categoryID;
    private String pBrand;
    private int  stockQuantity;
    private String imageUrl;
   

}
