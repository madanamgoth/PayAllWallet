package com.payallwallet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payallwallet.model.UserTransactions;

@Repository
public interface UserTransactionsRepository extends JpaRepository<UserTransactions, String> {
	
	List<UserTransactions> findUserTransactionsByUserIdAndCardId(String userId,String cardId);
}
