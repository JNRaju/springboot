/**
 * 
 */
package com.jnr.app.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnr.app.controller.UserController;
import com.jnr.app.entity.User;
import com.jnr.app.repository.UserRepository;

/**
 * @author JNRaju
 *
 */

@Service
public class UserServiceImpl implements UserService{
	
	private static Logger logger = Logger.getLogger(UserController.class);

	
	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserDetailsById(Integer id) {
		
		return userRepository.getOne(id);
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(Integer Id) {
		userRepository.deleteById(Id);
		
	}

	@Override
	public User updateUserById(User user, Integer id) {
		logger.info("## inside UserServiceImpl updateUserById() ##" );
		User retrievedUser = userRepository.getOne(id);
		logger.info("##  given  ##" + retrievedUser);

		if(!retrievedUser.equals(null) ) {
			user.setUserId(id);
			logger.info("##  given USER_ID ##" + retrievedUser);
			return userRepository.save(user);
		}else {
			logger.error("## No records found with the given USER_ID ##");
			return null;
		}
		
		
		
	}

}
