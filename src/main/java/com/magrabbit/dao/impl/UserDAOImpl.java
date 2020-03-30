package com.magrabbit.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.magrabbit.dao.IUserDAO;
import com.magrabbit.dao.repository.UserRepository;
import com.magrabbit.entity.User;

/**
 * User Dao Implementation
 * 
 * @author Chiem Lam Mai
 * @since 07-09-2019
 */
@Repository("userDao")
@Transactional
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Find By Username
	 * 
	 * @param userName
	 * @return Optional<User>
	 */
	@Override
	public Optional<User> findByUsername(String userName) {
		return userRepository.findById(userName);
	}
}