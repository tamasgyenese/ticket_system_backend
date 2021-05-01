package com.core.userdetails.dao;

public interface ICoreUserDetailsDAO {

    /**
     * This method validates the given threeSet is valid or not
     * @param email
     * @param userId
     * @param deviceHash
     * @return
     */
    long isValidToken(String email, long userId, String deviceHash, String token);

    long validateBankCard(long userId, String cardId, long eventId, String seatId);




}
