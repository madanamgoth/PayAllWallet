package com.payallwallet.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_transactions")
public class UserTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transaction_id")
    private String transactionId;
   
    @Column(name="user_id")
    private String userId;
    
    @Column(name="card_id")
    private String cardId;
    
    @Column(name="amount")
    private String amount;
    
    @Column(name="status")
    private String status;
    
    @Column(name="transaction_type")
    private String transactionType;
    
    @Column(name="created_on")
    private Date createdOn;

		
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
    
  }
