/**
 * 
 */
package com.jnr.app.service;

import java.util.List;

import com.jnr.app.entity.User;

/**
 * @author JNRaju
 *
 */
public interface UserService {
		User getUserDetailsById(Integer id);
		
		User saveUser(User user);
		
		List<User> getAllUsers();
		
		void deleteUserById(Integer Id);
		
		User updateUserById(User user,Integer Id);
}
