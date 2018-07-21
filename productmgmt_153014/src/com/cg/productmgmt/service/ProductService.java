package com.cg.productmgmt.service;

import java.util.Map;

import com.cg.productmgmt.bean.Product;
import com.cg.productmgmt.exception.ProductException;
/**
 * Interface : ProductService Author: Sushmitha Date: 4th July, 2018
 * 
 * Purpose: Creation of service utilities
 * 
 */
public interface ProductService {
	public int updateProducts(String Category,int hike) throws ProductException;
	public Map<String,String> getProductDetails() throws ProductException;
	boolean validateProduct(Product p) throws ProductException;
	public Map<String,Integer> getDetails() throws ProductException;
}
