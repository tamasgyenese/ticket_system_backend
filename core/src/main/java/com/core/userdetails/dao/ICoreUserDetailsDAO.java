package com.core.userdetails.dao;

import com.core.exception.CoreDAOException;

public interface ICoreUserDetailsDAO {

    /**
     * This method validates the given threeSet is valid or not
     * @param email
     * @param userId
     * @param deviceHash
     * @return
     */
    long isValidToken(String email, long userId, String deviceHash, String token) throws CoreDAOException;

    long validateBankCard(long userId, String cardId, long eventId, String seatId) throws CoreDAOException;

    void chargeMoneyFromCard(String cardId, long eventId, String seatId) throws CoreDAOException;




}
