package com.payallwallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payallwallet.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findUserByEmailAndStatus(String post_id,String status);

}
