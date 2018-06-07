package com.payallwallet.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payallwallet.model.User;
import com.payallwallet.model.UserCard;
import com.payallwallet.service.PayAllWalletService;

@RestController
@EnableAutoConfiguration
public class PayAllWalletController {
	@Autowired
	PayAllWalletService payAllWalletService;
	
	@RequestMapping(value = "/registerUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object registerUser(@RequestBody User user) {
        Map<String,Object> response = new HashMap<>();
		
		try {
        	response = payAllWalletService.registerUser(user);
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "Fail");
        }

        return response;
    }
	
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object login(@RequestBody User user) {
        Map<String,Object> response = new HashMap<>();		
		try {
        	response = payAllWalletService.login(user);
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "Fail");
        }
        return response;
    }
	
	@RequestMapping(value = "/addCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addCard(@RequestBody UserCard userCard) {
        Map<String,Object> response = new HashMap<>();
		try {
			response = payAllWalletService.addCard(userCard);
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }
	
	@RequestMapping(value = "/getAllCards", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAllCards(@RequestBody Map<String,String> userCard) {
        Map<String,Object> response = new HashMap<>();
		try {
			response = payAllWalletService.getAllCards(userCard.get("userId"));
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }
	
	@RequestMapping(value = "/getTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getTransactions(@RequestBody Map<String,String> userCard) {
        Map<String,Object> response = new HashMap<>();
		try {
			response = payAllWalletService.getTransactionsForCard(userCard.get("userId"),userCard.get("cardId"));
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }
	
	@RequestMapping(value = "/generateCardPin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object generateCardPin(@RequestBody Map<String,String> userCard) {
        Map<String,Object> response = new HashMap<>();
		try {
			response = payAllWalletService.getPin(userCard.get("userId"),userCard.get("cardId"));
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }
	
	@RequestMapping(value = "/deleteCards", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteCards() {
        Map<String,Object> response = new HashMap<>();
		try {
			response = payAllWalletService.deleteCards();
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }
	
	@RequestMapping(value = "/deleteUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteUsers() {
        Map<String,Object> response = new HashMap<>();
		try {
			response = payAllWalletService.deleteUsers();
        } catch (Exception e) {
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }

}
 