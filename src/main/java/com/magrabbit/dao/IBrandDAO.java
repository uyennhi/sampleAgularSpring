package com.magrabbit.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Brand;
import com.magrabbit.utility.PageModel;

/**
 * Brand Dao Interface
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
public interface IBrandDAO extends GenericDAO<Brand, Integer> {

	/**
	 * Get all brand name
	 * 
	 * @return List<String>
	 */
	List<String> getAllBrandName();

	/**
	 * Get brands by pageable
	 * 
	 * @param brandName
	 * @param pageable
	 * @return PageModel<Brand>
	 */
	PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage);
}