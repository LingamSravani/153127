package com.cg.productmgmt.service;

import java.util.Map;

import com.cg.productmgmt.bean.Product;
import com.cg.productmgmt.dao.IProductDAO;
import com.cg.productmgmt.dao.ProductDAO;
import com.cg.productmgmt.exception.ProductException;

/**
 * Class : IProductService Author: Sushmitha Date: 4th July, 2018
 * 
 * Purpose: Creation of service implementation class.
 * 
 */
public class IProductService implements ProductService {
	ProductDAO productDao = new IProductDAO();

	/**
	 * Method name: updateProducts return type: int parameters: category, hike
	 */
	@Override
	public int updateProducts(String Category, int hike) throws ProductException {
		if (validateCategory(Category) && validateHike(hike)) {
			return productDao.updateProducts(Category, hike);
		}
		return 0;
	}

	/**
	 * Method name: getProductDetails return type: productDetails
	 */
	@Override
	public Map<String, String> getProductDetails() throws ProductException {

		return productDao.getProductDetails();
	}

	/**
	 * Method name: validateProduct return type: boolean
	 * 
	 */
	@Override
	public boolean validateProduct(Product p) throws ProductException {
		if (validateHike(p.getHike()) && validateCategory(p.getCategory())) {
			return true;
		}
		return false;
	}
/**
 * Method name: validateHike
 * return type: boolean
 * purpose: Validates that hike has to be above 0
 */
	private boolean validateHike(int hike) throws ProductException {
		if (hike > 0) {
			return true;
		} else {
			throw new ProductException("The hike rate should be > 0");
		}

	}
/**
 * Method name: validateCategory
 * Return type: boolean
 * purpose: Checks that category entered should be existing in the hashmap
 */

	private boolean validateCategory(String category) throws ProductException {
		try {
			if (productDao.getProductDetails().containsValue(category)) {

				return true;
			}
		} catch (ProductException e) {
			throw new ProductException("Category not in list");
		}

		return false;

	}

	@Override
	public Map<String, Integer> getDetails() throws ProductException {
		return productDao.getDetails();
	}
}
