package com.magrabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magrabbit.entity.Brand;
import com.magrabbit.service.IBrandService;
import com.magrabbit.utility.Constrains;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;

/**
 * Product Controller
 * 
 * @author Chiem Lam Mai
 * @since 09-09-2019
 */
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	IBrandService brandService;

	/**
	 * Get Brands by pageable
	 * 
	 * @param page
	 * @param name
	 * @return PageModel<Brand>
	 */
	@GetMapping(value = "/general/get-brands", params = { "page", "name" })
	public PageModel<Brand> getBrandsByPageable(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "name") String name) {
		return brandService.getBrandsByPageable(name, PageRequest.of(page, Constrains.PAGE_SIZE), page);
	}

	/**
	 * Find Brand by brand name
	 * 
	 * @param brandName
	 * @return Brand
	 */
	@GetMapping(value = "/general/find-brand-by-name/{brandName}")
	public Brand findBrandByBrandName(@PathVariable("brandName") String brandName) {
		return brandService.findBrandByName(brandName);
	}

	/**
	 * Get all brand name
	 * 
	 * @return List<String>
	 */
	@GetMapping(value = "/general/get-all-brand-name")
	public List<String> getAllBrandName() {
		return brandService.getAllBrandName();
	}

	/**
	 * Insert Brand
	 * 
	 * @param Brand
	 * @return ResponseModel
	 */
	@PostMapping(value = "/admin/insert-brand")
	public ResponseModel insertBrand(@RequestBody Brand brand) {
		return brandService.insertBrand(brand);
	}

	/**
	 * Update Brand
	 * 
	 * @param Brand
	 * @return ResponseModel
	 */
	@PutMapping(value = "/admin/update-brand")
	public ResponseModel updateBrand(@RequestBody Brand brand) {
		return brandService.updateBrand(brand);
	}

	/**
	 * Delete Brand
	 * 
	 * @param Brand
	 * @return ResponseModel
	 */
	@PostMapping(value = "/admin/delete-brand")
	public ResponseModel deleteBrand(@RequestBody Brand brand) {
		return brandService.deleteBrand(brand);
	}
}