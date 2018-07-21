package com.cg.productmgmt.bean;
/**
 * Class : Product Author: Sushmitha Date: 4th July, 2018
 * 
 * Purpose: Bean class is Product, it has the attributes, getters and setters, constructors and toString method.
 */
public class Product {
	private String productName;
	private String Category;
	private int hike;
	private int price;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getHike() {
		return hike;
	}

	public void setHike(int hike) {
		this.hike = hike;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product(String productName, String category, int hike, int price) {
		super();
		this.productName = productName;
		Category = category;
		this.hike = hike;
		this.price = price;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", Category=" + Category + ", hike=" + hike + ", price=" + price
				+ "]";
	}

}
