package com.magrabbit.dao;

import java.io.Serializable;

/**
 * Generic Dao Interface
 * 
 * @author Chiem Lam Mai
 * @since 07-09-2019
 */
public interface GenericDAO<T, K extends Serializable> {

	/**
	 * Save T
	 * 
	 * @param T Entity
	 */
	void insertOrUpdate(T entity);

	/**
	 * Delete T
	 * 
	 * @param T
	 */
	void delete(T entity);

	/**
	 * Find T by name
	 * 
	 * @param name
	 * @return T
	 */
	T findByName(String name);
}