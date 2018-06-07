package com.payallwallet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payallwallet.model.UserCard;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, String> {
	
	UserCard findUserCardByUserIdAndCardNumberAndStatus(String userId,String cardNumber,String status);
	UserCard findUserCardByUserIdAndCardIdAndStatus(String userId,String cardNumber,String status);
	List<UserCard> findUserCardByUserIdAndStatus(String userId,String status);
}
