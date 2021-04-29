package com.gyenese.dao;

public interface ICoreValidatorDAO {

    /**
     * This method validates the given threeSet is valid or not
     * @param email
     * @param userId
     * @param deviceHash
     * @return
     */
    boolean isValidToken(String email, long userId, String deviceHash, String token);




}
