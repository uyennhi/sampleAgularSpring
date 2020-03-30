package com.magrabbit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IProductDAO;
import com.magrabbit.entity.Product;
import com.magrabbit.service.IProductService;
import com.magrabbit.utility.Constrains;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;
import com.magrabbit.utility.SearchModel;

/**
 * Product Service Implementation
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDAO productDao;

	/**
	 * Insert Product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel insertProduct(Product product) {
		productDao.insertOrUpdate(product);
		return new ResponseModel(HttpStatus.OK, Constrains.INSERT_PRODUCT_SUCCESSFUL);
	}

	/**
	 * Update Product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel updateProduct(Product product) {
		productDao.insertOrUpdate(product);
		return new ResponseModel(HttpStatus.OK, Constrains.UPDATE_PRODUCT_SUCCESSFUL);
	}

	/**
	 * Delete Product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel deleteProduct(Product product) {
		productDao.delete(product);
		return new ResponseModel(HttpStatus.OK, Constrains.DELETE_PRODUCT_SUCCESSFUL);
	}

	/**
	 * Check exist product name
	 * 
	 * @param productName
	 * @return boolean
	 */
	@Override
	public boolean isExistProductName(String productName) {
		Product product = productDao.findByName(productName);
		return (product != null) ? true : false;
	}

	/**
	 * Get products by pageable
	 * 
	 * @param searchModel
	 * @param pageable
	 * @return PageModel<Product>
	 */
	@Override
	public PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage) {
		return productDao.getProductsByPageable(searchModel, pageable, currentPage);
	}
}