package com.cg.productmgmt.dao;
/**
 * Interface : ProductDAO Author: Sushmitha Date: 4th July, 2018
 * 
 * Purpose: Creation of DAO interface
 * 
 */
import java.util.Map;

import com.cg.productmgmt.bean.Product;
import com.cg.productmgmt.exception.ProductException;

public interface ProductDAO {
public int updateProducts(String Category,int hike) throws ProductException;
public Map<String,String> getProductDetails() throws ProductException;
public Map<String,Integer> getDetails() throws ProductException;

}
