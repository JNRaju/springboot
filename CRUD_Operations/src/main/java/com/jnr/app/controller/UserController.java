/**
 * @author JNRaju
 *
 */
package com.jnr.app.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnr.app.entity.User;
import com.jnr.app.service.UserService;

/**
 * @author JNRaju
 *
 */

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@GetMapping(value = "/getUserDetails/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		logger.info("## inside UserController getUserById() ##");
		User user= null;
		
		try {
			user = userService.getUserDetailsById(userId);
			
		}catch(Exception e){
			logger.error("## Exception in getUserById() ##" + e);
			return new ResponseEntity<>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		logger.info("## inside UserController createUser() ##");
		User saveUser= null;
		
		try {
			saveUser = userService.saveUser(user);
		}catch(Exception e){
			logger.error("## Exception in createUser() ##" + e);
			return new ResponseEntity<>(saveUser,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<User>(saveUser,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/updagteUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user){
		logger.info("## inside UserController updateUser() ##");
		User updateUser= null;
		
		try {
			updateUser = userService.updateUserById(user, userId);
		}catch(Exception e){
			logger.error("## Exception in updateUser() ##" + e);
			return new ResponseEntity<>(updateUser,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<User>(updateUser,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		logger.info("## inside UserController getAllUsers() ##");
		List<User> users = null;
		
		try {
			users = userService.getAllUsers();
			
		}catch(Exception e){
			logger.error("## Exception in getAllUsers() ##" + e);
			return new ResponseEntity<>(users,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteUser/{userId}")
	public ResponseEntity<User> deleteUserById(@PathVariable("userId") Integer userId){
		logger.info("## inside UserController deleteUserById() ##");

		
		try {
			 userService.deleteUserById(userId);
			
		}catch(Exception e){
			logger.error("## Exception in deleteUserById() ##" + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  return new ResponseEntity<User>(HttpStatus.OK);
		
	}

}
