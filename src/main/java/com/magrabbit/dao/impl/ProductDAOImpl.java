package com.magrabbit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.magrabbit.dao.IProductDAO;
import com.magrabbit.dao.repository.ProductRepository;
import com.magrabbit.entity.Brand;
import com.magrabbit.entity.Product;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.SearchModel;

/**
 * Product Dao Implementation
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
@Repository("productDao")
@Transactional
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private EntityManager em;

	/**
	 * Insert or update product
	 * 
	 * @param product
	 */
	@Override
	public void insertOrUpdate(Product entity) {
		productRepository.save(entity);
	}

	/**
	 * Delete product
	 * 
	 * @param product
	 */
	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	/**
	 * Find product by product name
	 * 
	 * @param productName
	 * @return boolean
	 */
	@Override
	public Product findByName(String productName) {
		return productRepository.findByProductName(productName);
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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Brand> brand = cq.from(Brand.class);
		Join<Brand, Product> product = brand.join("productSet");
		cq.select(product);

		// Set condition
		setConditionSearchProducts(searchModel, cb, cq, brand, product);

		TypedQuery<Product> query = em.createQuery(cq);

		// Set pageable
		int totalPage = (query.getResultList().size() - 1) / pageable.getPageSize() + 1;
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		PageModel<Product> pageModel = new PageModel<Product>(query.getResultList(), pageable, totalPage, currentPage);

		return pageModel;
	}

	/**
	 * Set condition search products
	 * 
	 * @param searchModel
	 * @param criteriaBuilder
	 * @param criteriaQuery
	 * @param brand
	 * @param product
	 */
	private void setConditionSearchProducts(SearchModel searchModel, CriteriaBuilder cb, CriteriaQuery<Product> cq,
			Root<Brand> brand, Join<Brand, Product> product) {

		// List condition
		List<Predicate> predicates = new ArrayList<Predicate>();

		// Sort order if search by price
		Order sortPrice = cb.desc(product.get("price"));

		// Condition if searching by product name
		if (searchModel.getProductName() != "") {
			Predicate productNameCondition = cb.like(product.get("productName"),
					"%" + searchModel.getProductName() + "%");
			predicates.add(productNameCondition);
		}

		// Condition if searching by brand name
		if (searchModel.getBrandName() != "") {
			Predicate brandNameCondition = cb.like(brand.get("brandName"), searchModel.getBrandName());
			predicates.add(brandNameCondition);
		}

		// Condition if searching by min price
		if (searchModel.getPriceFrom() != 0 && searchModel.getPriceTo() == 0) {
			Predicate priceFromCondition = cb.ge(product.get("price"), searchModel.getPriceFrom());
			predicates.add(priceFromCondition);
			cq.orderBy(sortPrice);
		}

		// Condition if searching by max price
		if (searchModel.getPriceFrom() == 0 && searchModel.getPriceTo() != 0) {
			Predicate priceToCondition = cb.le(product.get("price"), searchModel.getPriceTo());
			predicates.add(priceToCondition);
			cq.orderBy(sortPrice);
		}

		// Condition if searching from min price to max price
		if (searchModel.getPriceFrom() != 0 && searchModel.getPriceTo() != 0) {
			Predicate priceCondition = cb.between(product.get("price"), searchModel.getPriceFrom(),
					searchModel.getPriceTo());
			predicates.add(priceCondition);
			cq.orderBy(sortPrice);
		}

		cq.where(predicates.toArray(new Predicate[] {}));
	}
}