package com.magrabbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IBrandDAO;
import com.magrabbit.entity.Brand;
import com.magrabbit.service.IBrandService;
import com.magrabbit.utility.Constrains;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;

/**
 * Brand Service Implementation
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	IBrandDAO brandDao;

	/**
	 * Insert Brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel insertBrand(Brand brand) {
		brandDao.insertOrUpdate(brand);
		return new ResponseModel(HttpStatus.OK, Constrains.INSERT_BRAND_SUCCESSFUL);
	}

	/**
	 * Update Brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel updateBrand(Brand brand) {
		brandDao.insertOrUpdate(brand);
		return new ResponseModel(HttpStatus.OK, Constrains.UPDATE_BRAND_SUCCESSFUL);
	}

	/**
	 * Delete Brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel deleteBrand(Brand brand) {
		brandDao.delete(brand);
		return new ResponseModel(HttpStatus.OK, Constrains.DELETE_BRAND_SUCCESSFUL);
	}

	/**
	 * Get Brand name
	 * 
	 * @return List<String>
	 */
	@Override
	public List<String> getAllBrandName() {
		return brandDao.getAllBrandName();
	}

	/**
	 * Find brand by brand name
	 * 
	 * @param brandName
	 * @return Brand
	 */
	@Override
	public Brand findBrandByName(String brandName) {
		return brandDao.findByName(brandName);
	}

	/**
	 * Get brands by pageable
	 * 
	 * @param brandName
	 * @param pageable
	 * @return PageModel<Brand>
	 */
	@Override
	public PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage) {
		return brandDao.getBrandsByPageable(brandName, pageable, currentPage);
	}
}