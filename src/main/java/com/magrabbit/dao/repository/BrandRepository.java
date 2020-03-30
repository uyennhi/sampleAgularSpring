package com.magrabbit.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.magrabbit.entity.Brand;

/**
 * Brand Repository
 * 
 * @author Chiem Lam Mai
 * @since 20-09-2019
 */
@Repository("brandRepository")
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	/**
	 * Find brand by brand name query
	 * 
	 * @param brandName
	 * @return Brand
	 */
	Brand findByBrandName(String brandName);

	/**
	 * Get all brand name query
	 * 
	 * @return List<String>
	 */
	@Query("SELECT b.brandName FROM Brand b")
	List<String> getAllBrandName();
}