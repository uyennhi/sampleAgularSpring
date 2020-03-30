package com.magrabbit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IUserDAO;
import com.magrabbit.entity.User;
import com.magrabbit.service.IUserDetailService;

/**
 * UserDetailService Implementation
 * 
 * @author Chiem Lam Mai
 * @since 13-09-2019
 */
@Service("userService")
public class UserDetailServiceImpl implements IUserDetailService {

	@Autowired
	IUserDAO userDAO;

	/**
	 * Authentication user login load user detail for authorization
	 *
	 * @param username
	 * @return UserDetail
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDAO.findByUsername(username).get();
		UserBuilder builder = null;

		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
			builder.roles(user.getRole());
		} else {
			throw new UsernameNotFoundException("User not found");
		}

		return builder.build();
	}
}