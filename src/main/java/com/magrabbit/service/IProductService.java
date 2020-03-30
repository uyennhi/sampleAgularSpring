package com.magrabbit.service;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Product;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;
import com.magrabbit.utility.SearchModel;

/**
 * Product Service Interface
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
public interface IProductService {

	/**
	 * Insert product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	ResponseModel insertProduct(Product product);

	/**
	 * Update product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	ResponseModel updateProduct(Product product);

	/**
	 * Delete product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	ResponseModel deleteProduct(Product product);

	/**
	 * Check product already exists
	 * 
	 * @param productName
	 * @return boolean
	 */
	boolean isExistProductName(String productName);

	/**
	 * Get products by pageable
	 * 
	 * @param searchModel
	 * @param pageable
	 * @return PageModel<Product>
	 */
	PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage);
}