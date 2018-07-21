package com.cg.productmgmt.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cg.productmgmt.exception.ProductException;

/**
 * Class : IProductDAO Author: Sushmitha Date: 4th July, 2018
 * 
 * Purpose: Data manipulation of associated product data No. of methods: 3
 * 
 */
public class IProductDAO implements ProductDAO {
	static Map<String, String> productDetails;
	static Map<String, Integer> salesDetails;

	static {
		productDetails = new HashMap<>();
		productDetails.put("lux", "soap");
		productDetails.put("colgate", "paste");
		productDetails.put("pears", "soap");
		productDetails.put("sony", "electronics");
		productDetails.put("samsung", "electronics");
		productDetails.put("facepack", "cosmatics");
		productDetails.put("facecream", "cosmatics");

		salesDetails = new HashMap<>();
		salesDetails.put("lux", 100);
		salesDetails.put("colgate", 50);
		salesDetails.put("pears", 70);
		salesDetails.put("sony", 10000);
		salesDetails.put("samsung", 23000);
		salesDetails.put("facepack", 100);
		salesDetails.put("facecream", 60);

	}

	/**
	 * Method name: updateProducts parameters:Category, hike return type:int
	 * purpose: to update product details Date of creation: 4th July,2018 Last
	 * modified Date: 4th July,2018
	 */
	
	@Override
	public int updateProducts(String Category, int hike) throws ProductException {
		Set<String> products = new HashSet<>();
		int newPrice = 0;
		int updated = 0;
		Set<String> keys = productDetails.keySet();
		String value = null;
		for (String key : keys) {
			value = productDetails.get(key);
			if (value.equals(Category)) {
				products.add(key);
			}
		}

		Set<String> keySales = salesDetails.keySet();
		for (String sale : keySales) {
			if (products.contains(sale)) {
				newPrice = salesDetails.get(sale);
				newPrice = newPrice + hike;
				salesDetails.put(sale, newPrice);
				updated = 1;
			}
		}
		return updated;
	}

	/**
	 * Method name: getProductdetails return type: productDetails purpose: to get
	 * product details Date of creation: 4th July,2018 Last modified Date: 4th
	 * July,2018
	 */

	@Override
	public Map<String, String> getProductDetails() throws ProductException {
		return productDetails;
	}

	/**
	 * Method name: getDetails return type: salesDetails purpose: to get sales
	 * details Date of creation: 4th July,2018 Last modified Date: 4th July,2018
	 */
	
	@Override
	public Map<String, Integer> getDetails() throws ProductException {
		return salesDetails;
	}

}
