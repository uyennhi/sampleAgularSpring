package com.magrabbit.dao;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Product;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.SearchModel;

/**
 * Product Dao Interface
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
public interface IProductDAO extends GenericDAO<Product, Integer> {

	/**
	 * Get products by pageable
	 * 
	 * @param searchModel
	 * @param pageable
	 * @return PageModel<Product>
	 */
	PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage);
}