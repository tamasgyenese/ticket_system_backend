package com.gyenese.model;

import java.util.Objects;

/**
 * POJO for UserBankCard table
 */

public class UserBankCard {

    private long userId;
    private String cardId;
    private String cardNumber;
    private int cvc;
    private String name;
    private long amount;
    private String currency;

    public UserBankCard() {
    }

    public UserBankCard(long userId, String cardId, String cardNumber, int cvc, String name, long amount, String currency) {
        this.userId = userId;
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBankCard that = (UserBankCard) o;
        return userId == that.userId &&
                cardNumber == that.cardNumber &&
                cvc == that.cvc &&
                amount == that.amount &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, cardId, cardNumber, cvc, name, amount, currency);
    }

    @Override
    public String toString() {
        return "UserBankCard{" +
                "userId=" + userId +
                ", cardId='" + cardId + '\'' +
                ", cardNumber=" + cardNumber +
                ", cvc=" + cvc +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
