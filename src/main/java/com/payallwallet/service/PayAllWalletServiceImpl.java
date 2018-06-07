package com.payallwallet.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payallwallet.dao.UserCardRepository;
import com.payallwallet.dao.UserRepository;
import com.payallwallet.dao.UserTransactionsRepository;
import com.payallwallet.model.User;
import com.payallwallet.model.UserCard;
import com.payallwallet.model.UserTransactions;
import com.payallwallet.util.Util;

@Service
public class PayAllWalletServiceImpl implements PayAllWalletService {
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserCardRepository userCardRepository;
	@Autowired
	UserTransactionsRepository userTransactionsRepository;

	@Override
	public Map<String,Object> registerUser(User user) {
		
		User userExists = userRepository.findUserByEmailAndStatus(user.getEmail(), "Y");
		if(null == userExists){
			user.setStatus("Y");
			user.setCreatedOn(new Date());
			userRepository.save(user);
			return getResponse("Success","User successfully registered");
		}
		return getResponse("Fail","User already registered with given email");
	}
	
	@Override
	public Map<String, Object> login(User user) {
		
		User userExists = userRepository.findUserByEmailAndStatus(user.getPostId(), "Y");
		if(null != userExists && userExists.getPassword().equals(user.getPassword())){
			Map<String,Object> resMap = getResponse("Success","User successfully logged in");
			resMap.put("userId", userExists.getUserId());			
			return resMap;
		}		
		return getResponse("Fail","Login failed");
	}
	
	@Override
	public Map<String,Object> addCard(UserCard userCard) {
		
		UserCard userCardExists = userCardRepository.findUserCardByUserIdAndCardNumberAndStatus(userCard.getUserId(),userCard.getCardNumber(), "Y");
		if(null == userCardExists){
			userCard.setStatus("Y");
			userCard.setCreatedOn(new Date());
			userCardRepository.save(userCard);
			addTxn(userCard.getUserId(), userCard.getCardId());
			return getResponse("Success","Card added successfully");
		}
		return getResponse("Fail","Card already exists for the user");
	}
	
	
	@Override
	public Map<String,Object> getAllCards(String userId) {
		
		List<UserCard> cardList = userCardRepository.findUserCardByUserIdAndStatus(userId, "Y");
		if(null != cardList && !cardList.isEmpty()){
			Map<String,Object> resMap = getResponse("Success","success");
			resMap.put("cardList", cardList);	
			return resMap;
		}
		return getResponse("Fail","Cards not exists for the user");
	}
	
	@Override
	public Map<String,Object> deleteCards() {
		
		userCardRepository.deleteAll();
		
		return getResponse("Success","success");
	}
	
	@Override
	public Map<String,Object> deleteUsers() {
		
		userRepository.deleteAll();
		
		return getResponse("Success","success");
	}
	
	
	@Override
	public Map<String,Object> getPin(String userId,String cardId) throws Exception {
		
		UserCard card = userCardRepository.findUserCardByUserIdAndCardIdAndStatus(userId, cardId, "Y");
		if(null != card ){
			Map<String,Object> resMap = getResponse("Success","success");
			String cardPin = String.valueOf(Util.generateRandomValue(4));
			resMap.put("cardPin", cardPin);
			resMap.put("cardId", cardId);
			card.setCardPin(cardPin);
			userCardRepository.save(card);
			return resMap;
		}
		return getResponse("Fail","Cards not exists for the user");
	}
	
	@Override
	public Map<String,Object> getTransactionsForCard(String userId,String cardId) {
		
		List<UserTransactions> userTxnList = userTransactionsRepository.findUserTransactionsByUserIdAndCardId(userId, cardId);
		if(null != userTxnList && !userTxnList.isEmpty()){
			Map<String,Object> resMap = getResponse("Success","success");
			resMap.put("userTxnList", userTxnList);	
			return resMap;
		}
		return getResponse("Fail","User tranactions not exists for the card");
	}


	
	private Map<String,Object> getResponse(String status,String message){
		Map<String,Object> responseMap = new HashMap<>();
		responseMap.put("status", status);
		responseMap.put("message", message);
		return responseMap;
		
	}
	
	private void addTxn(String userId,String cardId){
		
		UserTransactions userTransactions = new UserTransactions();
		userTransactions.setCardId(cardId);
		userTransactions.setAmount("100.00");
		userTransactions.setStatus("TS");
		userTransactions.setUserId(userId);
		userTransactions.setTransactionType("PAY");
		userTransactions.setCreatedOn(new Date());
		userTransactionsRepository.save(userTransactions);
		userTransactions = new UserTransactions();
		userTransactions.setCardId(cardId);
		userTransactions.setAmount("200.00");
		userTransactions.setStatus("TF");
		userTransactions.setUserId(userId);
		userTransactions.setTransactionType("PAY");
		userTransactions.setCreatedOn(new Date());
		userTransactionsRepository.save(userTransactions);
	}




	
	
}
