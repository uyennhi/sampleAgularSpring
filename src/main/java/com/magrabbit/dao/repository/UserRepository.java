package com.magrabbit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magrabbit.entity.User;

/**
 * User Repository
 * 
 * @author Chiem Lam Mai
 * @since 20-09-2019
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
}