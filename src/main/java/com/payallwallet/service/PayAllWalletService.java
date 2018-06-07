package com.payallwallet.service;

import java.util.Map;

import com.payallwallet.model.User;
import com.payallwallet.model.UserCard;

public interface PayAllWalletService {
	
	public Map<String,Object> registerUser(User user);	
	public Map<String,Object> login(User user);
	public Map<String, Object> addCard(UserCard userCard);
	Map<String, Object> getAllCards(String userId);
	Map<String, Object> getTransactionsForCard(String userId, String cardId);
	Map<String, Object> getPin(String userId, String cardId) throws Exception;
	Map<String, Object> deleteCards();
	Map<String, Object> deleteUsers();

}
