package com.magrabbit.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Brand;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;

/**
 * Brand Service Interface
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
public interface IBrandService {

	/**
	 * Insert brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	ResponseModel insertBrand(Brand brand);

	/**
	 * Update brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	ResponseModel updateBrand(Brand brand);

	/**
	 * Delete brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	ResponseModel deleteBrand(Brand brand);

	/**
	 * Find brand by name
	 * 
	 * @param brandName
	 * @return Brand
	 */
	Brand findBrandByName(String brandName);

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