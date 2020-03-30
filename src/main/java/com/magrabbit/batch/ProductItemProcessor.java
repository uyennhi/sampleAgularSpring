package com.magrabbit.batch;

import org.springframework.batch.item.ItemProcessor;

import com.magrabbit.entity.Product;

/**
 * Product ItemProcessor
 * 
 * @author Chiem Lam Mai
 * @since 01-10-2019
 */
public class ProductItemProcessor implements ItemProcessor<Product, Product> {

	/**
	 * Method used to process data before exporting
	 * 
	 * @param product
	 * @return product
	 */
	@Override
	public Product process(Product product) throws Exception {
		System.out.println("Processing product : " + product.getProductName());
		return product;
	}
}