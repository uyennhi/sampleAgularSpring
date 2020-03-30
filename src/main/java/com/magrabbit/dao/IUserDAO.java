package com.magrabbit.dao;

import java.util.Optional;

import com.magrabbit.entity.User;

/**
 * User Dao Interface
 * 
 * @author Chiem Lam Mai
 * @since 07-09-2019
 */
public interface IUserDAO {

	/**
	 * Find user by username
	 * 
	 * @param username
	 * @return Optional<User>
	 */
	Optional<User> findByUsername(String username);
}