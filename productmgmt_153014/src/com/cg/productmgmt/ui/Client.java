package com.cg.productmgmt.ui;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.cg.productmgmt.bean.Product;
import com.cg.productmgmt.exception.ProductException;
import com.cg.productmgmt.service.IProductService;
import com.cg.productmgmt.service.ProductService;

/**
 * Class : Client Author: Sushmitha Date: 4th July, 2018
 * 
 * Purpose: User interface that displays the menu and accepts the input from
 * user. Creating object for service and executing the respective methods.
 * 
 */

public class Client {
	Scanner scan = new Scanner(System.in);
	ProductService productService = new IProductService();

	public static void main(String[] args) {

		String option = null;

		Client c = new Client();
		while (true) {
			System.out.println("1. Update Product Price");
			System.out.println("2. Display Product List");
			System.out.println("3. Exit");
			System.out.println("Enter your choice: ");
			option = c.scan.nextLine();
			switch (option) {
			case "1":
				c.updateProducts();
				break;
			case "2":
				c.getProductDetails();
				break;
			case "3":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option, Choose from 1 to 6");
				break;
			}
		}
	}

	/**
	 * Method name: updateProducts purpose: We have to enter the product category
	 * and hike rate that needs to be updated. Date of creation: 4th July,2018 Last
	 * modified Date: 4th July,2018
	 */
	public void updateProducts() {
		Product p = new Product();
		System.out.println("Enter the Product Categoty: ");
		String category = scan.nextLine();
		System.out.println("Enter hike Rate: ");
		String hikerate = scan.nextLine();
		try {
			int hike = Integer.parseInt(hikerate);
			int pro = productService.updateProducts(category, hike);
			if (pro == 1) {
				System.out.println("updated hike prices for category " + category + " by hike value of " + hike);
			}

		} catch (ProductException e) {
			System.out.println();
			System.err.println("Error occured " + e.getMessage());
			System.out.println();
		}
	}

	/**
	 * Method name: getProductDetails Purpose: to display the product details Date
	 * of creation: 4th July,2018 Last modified Date: 4th July,2018
	 */
	public void getProductDetails() {

		try {
			Map<String, Integer> product = productService.getDetails();
			Set set = product.entrySet();
			set.stream().forEach(System.out::println);
		} catch (ProductException e) {
			System.err.println("Error occured" + e.getMessage());
		}

	}

}
