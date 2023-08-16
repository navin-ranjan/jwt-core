package com.inn.navin.jwt.user.dao;

import java.util.List;

import com.inn.navin.jwt.user.model.User;

public interface UserDao {
  
  /**
   * add new User
   * @param user
   * @return
   */
	String addUser(User user);

	
	/**
	 * get all User from database
	 * @return
	 */
	List<User> findAllUser();

	/**
	 * get user details
	 * @param name
	 * @param email
	 * @param number
	 * @return
	 */
	User getUserDetails(String name, String email, String number);
	
	
/**
 * update User
 * @param user
 * @return
 */
	User updateUser(User user);
	
	
	/**
	 * get User by id
	 * @param uid
	 * @return
	 */
	User getUserById(int id);
	
	/**
	 * delete user data
	 * @param uid
	 */
	void deleteUser(int id);
}

