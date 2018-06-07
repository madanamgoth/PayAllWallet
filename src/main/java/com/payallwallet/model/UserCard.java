package com.payallwallet.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_card")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_id")
    private String cardId;
    
    @Column(name="user_id")
    private String userId;
   
    @Column(name="name_on_card")
    private String nameOnCard;
    
    @Column(name="expiry_month")
    private String expiryMonth;
    
    @Column(name="card_number")
    private String cardNumber;
    
    @Column(name="expiry_year")
    private String expiryYear;
    
    @Column(name="status")
    private String status;
    
    @Column(name="card_pin")
    private String cardPin;
    
    public Date getCardPinCreatedOn() {
		return cardPinCreatedOn;
	}

	public void setCardPinCreatedOn(Date cardPinCreatedOn) {
		this.cardPinCreatedOn = cardPinCreatedOn;
	}

	@Column(name="cardpin_created_on")
    private Date cardPinCreatedOn;
    
    @Column(name="created_on")
    private Date createdOn;

	

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
  }
