package com.core.service;

import com.core.common.ServiceResponse;
import com.core.constans.FieldConstants;
import com.core.constans.Messages;
import com.core.eventdetails.dao.ICoreEventDetailsDAO;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reserve;
import com.core.exception.CoreDAOException;
import com.core.userdetails.dao.ICoreUserDetailsDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@Service
public class CoreServiceImpl implements ICoreService {

    Logger logger = LoggerFactory.getLogger(CoreServiceImpl.class);

    private final ICoreEventDetailsDAO iCoreEventDetailsDAO;
    private final ICoreUserDetailsDAO iCoreUserDetailsDAO;

    @Autowired
    public CoreServiceImpl(ICoreEventDetailsDAO iCoreEventDetailsDAO, ICoreUserDetailsDAO iCoreUserDetailsDAO) {
        this.iCoreEventDetailsDAO = iCoreEventDetailsDAO;
        this.iCoreUserDetailsDAO = iCoreUserDetailsDAO;
    }

    /**
     * get all event from DAO after token validation
     * @param token
     * @return
     */
    @Override
    @Transactional
    public ServiceResponse<List<Event>> getEvents(String token) {
        long validator = isValidToken(token);
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        try {
            return new ServiceResponse<>(iCoreEventDetailsDAO.getEvents(), true);
        } catch (CoreDAOException e) {
            e.printStackTrace();
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(e.getErrorCode()), e.getErrorCode());
        }
    }

    /**
     * get event details for a given eventId after token validation
     * @param eventId
     * @param token
     * @return
     */
    @Override
    @Transactional
    public ServiceResponse<Event> getEventDetails(long eventId, String token) {
        long validator = isValidToken(token);
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        try {
            return new ServiceResponse<>(iCoreEventDetailsDAO.getEventDetails(eventId), true);
        } catch (CoreDAOException e) {
            e.printStackTrace();
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(e.getErrorCode()), e.getErrorCode());
        }
    }

    /**
     * Token validation
     * @param token64
     * @return
     */
    @Override
    @Transactional
    public long isValidToken(String token64) {
        logger.trace("Validate token: {}", token64);
        String email;
        long userId;
        String deviceHash;
        try {
            if (token64 == null || "".equals(token64)) {
                logger.error("Failure during validation for token: {} with error code: {}", token64, Messages.ERROR_CODE_10051);
                return Messages.ERROR_CODE_10051;
            }
            String[] values = decodedString(token64);
            if (values == null || values.length != 3) {
                logger.error("Failure during validation for token: {} with error code: {}", token64, Messages.ERROR_CODE_10051);
                return Messages.ERROR_CODE_10051;
            }
            email = values[0];
            userId = Long.parseLong(values[1]);
            deviceHash = values[2];
            logger.debug("Token validation for email: {}, user: {}, device hash: {} with token: {}", email, userId, deviceHash, token64);
            return iCoreUserDetailsDAO.isValidToken(email, userId, deviceHash, token64) == 1 ? Messages.SUCCESS_CODE : Messages.ERROR_CODE_10050;
        } catch (CoreDAOException e) {
            logger.error("Failure during validation for token: {}", token64);
            return e.getErrorCode();
        } catch (Exception ex) {
            logger.error("Failure during validation for token: {}", token64);
            return Messages.ERROR_CODE_10051;
        }
    }

    /**
     * validate event and bankcard after token validation, if everything is oke it reserves the seat
     * @param eventId
     * @param seatId
     * @param cardId
     * @param token
     * @return
     */
    @Override
    @Transactional
    public ServiceResponse<Reserve> payValidation(long eventId, String seatId, String cardId, String token) {
        logger.trace("Pay validation for event: {}, setad: {}, cardid: {}, token:{}", eventId, seatId, cardId, token);
        long validator = isValidToken(token);
        if (validator != Messages.SUCCESS_CODE) {
            logger.error("Failure during validation for token: {} with error code: {}", token, validator);
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        try {
            long userId = Long.parseLong(decodedString(token)[1]);
            long eventValidate = iCoreEventDetailsDAO.validateEvent(eventId, seatId);
            if (eventValidate != Messages.SUCCESS_CODE) {
                logger.error("Failure during event validation for event: {} and seat: {}", eventId, seatId);
                return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(eventValidate), eventValidate);
            }
            long cardValidate = iCoreUserDetailsDAO.validateBankCard(userId, cardId, eventId, seatId);
            if (cardValidate == Messages.SUCCESS_CODE) {
                logger.error("Failure during card validation for card: {} and user: {}", cardId, userId);
                iCoreEventDetailsDAO.reserveSeat(eventId, seatId);
            } else {
                return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(cardValidate), cardValidate);
            }
            return new ServiceResponse<>(true);
        } catch (CoreDAOException e) {
            logger.error("Failure during payvalidationfor event: {}, setad: {}, cardid: {}, token:{}", eventId, seatId, cardId, token);
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(e.getErrorCode()), e.getErrorCode());
        }
    }

    /**
     * decode base64 Token
     * @param token64
     * @return
     */
    public String[] decodedString(String token64) {
        byte[] decodedBytes = Base64.getDecoder().decode(token64);
        String decodedString = new String(decodedBytes);
        return decodedString.split(FieldConstants.TOKEN_SEPARATOR);
    }

}
