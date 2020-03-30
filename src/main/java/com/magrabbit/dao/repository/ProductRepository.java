package com.magrabbit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magrabbit.entity.Product;

/**
 * Product Repository
 * 
 * @author Chiem Lam Mai
 * @since 20-09-2019
 */
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**
	 * Find product by product name repository
	 * 
	 * @param productName
	 * @return product
	 */
	Product findByProductName(String productName);
}