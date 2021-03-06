package com.core.userdetails.dao;

import com.core.constans.FieldConstants;
import com.core.constans.Messages;
import com.core.constans.QueryConstants;
import com.core.exception.CoreDAOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CoreUserDetailsDAOimpl implements ICoreUserDetailsDAO {

    Logger logger = LoggerFactory.getLogger(CoreUserDetailsDAOimpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CoreUserDetailsDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Validate token ->  is there a user with a given paramters?
     * @param email
     * @param userId
     * @param deviceHash
     * @param token
     * @return
     * @throws CoreDAOException
     */
    @Override
    public long isValidToken(String email, long userId, String deviceHash, String token) throws CoreDAOException {
        logger.debug("Token validation for user: {} with token: {}", userId, token);
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_FIELD_EMAIL, email);
        namedParameters.put(FieldConstants.DB_FIELD_USER_ID, userId);
        namedParameters.put(FieldConstants.DB_FIELD_DEVICE_HASH, deviceHash);
        namedParameters.put(FieldConstants.DB_FIELD_TOKEN, token);
        try {
            return namedParameterJdbcTemplate.queryForObject(QueryConstants.VALIDATE_TOKEN, namedParameters, Long.class);
        } catch (Exception e) {
            logger.error("Error during token validation for user: {} with token: {}", userId, token);
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }

    /**
     * validate bank card -> check carid is related to the user, check amount to reserve the given seat at event
     * @param userId
     * @param cardId
     * @param eventId
     * @param seatId
     * @return
     * @throws CoreDAOException
     */
    @Override
    public long validateBankCard(long userId, String cardId, long eventId, String seatId) throws CoreDAOException {
        logger.debug("Bank card validation for user: {} with cardId {}", userId, cardId);
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_FIELD_USER_ID, userId);
        namedParameters.put(FieldConstants.DB_FIELD_CARD_ID, cardId);
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        namedParameters.put(FieldConstants.DB_ID, seatId);
        try {
            return namedParameterJdbcTemplate.queryForObject(QueryConstants.VALIDATE_PAYMENT, namedParameters, Long.class);
        }catch (Exception e) {
            logger.error("Error during bank card validation for user: {} with cardId: {}", userId, cardId);
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }

    }

    /**
     * Deposit money from the given card if the reservation for the required seat was ok
     * @param cardId
     * @param eventId
     * @param seatId
     * @throws CoreDAOException
     * @return
     */
    @Override
    public void chargeMoneyFromCard(String cardId, long eventId, String seatId) throws CoreDAOException {
        logger.trace("Deposit money from: {} card for event:{} and seat: {}", cardId, eventId, seatId);
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_FIELD_CARD_ID, cardId);
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        namedParameters.put(FieldConstants.DB_ID, seatId);
        try {
            namedParameterJdbcTemplate.update(QueryConstants.CHARGE_MONEY, namedParameters);
        } catch (Exception e) {
            logger.error("Error during charge money from: {} card for event:{} and seat: {}", cardId, eventId, seatId);
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }
}
