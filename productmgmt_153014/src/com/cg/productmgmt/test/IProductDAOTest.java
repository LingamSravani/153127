package com.cg.productmgmt.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.productmgmt.dao.IProductDAO;
import com.cg.productmgmt.dao.ProductDAO;
import com.cg.productmgmt.exception.ProductException;

public class IProductDAOTest {
	ProductDAO dao=null;
	
	@Before
	public void setup() {
		dao=new IProductDAO();
	}
	
	@After
	public void tearDown() {
		
	}
	@Test
	public void testUpdateProductsPositive() {
		try {
			assertEquals(1, dao.updateProducts("electronics", 500));
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateProductsNegative() {
		try {
			assertEquals(0, dao.updateProducts("medical", 500));
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	@Test
	public void testGetProductDetails() {
		try {
			Map<String, String> product =dao.getProductDetails();
			assertEquals(7, product.size());
			}
			catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
