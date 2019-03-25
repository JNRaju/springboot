/**
 * 
 */
package com.jnr.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnr.app.entity.User;

/**
 * @author JNRaju
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
