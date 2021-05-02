package com.core.service;

import com.core.common.ServiceResponse;
import com.core.constans.FieldConstants;
import com.core.constans.Messages;
import com.core.eventdetails.dao.ICoreEventDetailsDAO;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reserve;
import com.core.exception.CoreDAOException;
import com.core.userdetails.dao.ICoreUserDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@Service
public class CoreServiceImpl implements ICoreService {

    private final ICoreEventDetailsDAO iCoreEventDetailsDAO;
    private final ICoreUserDetailsDAO iCoreUserDetailsDAO;

    @Autowired
    public CoreServiceImpl(ICoreEventDetailsDAO iCoreEventDetailsDAO, ICoreUserDetailsDAO iCoreUserDetailsDAO) {
        this.iCoreEventDetailsDAO = iCoreEventDetailsDAO;
        this.iCoreUserDetailsDAO = iCoreUserDetailsDAO;
    }

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

    @Override
    @Transactional
    public long isValidToken(String token64) {
        try {
            if (token64 == null || "".equals(token64)) {
                return Messages.ERROR_CODE_10051;
            }
            String[] values = decodedString(token64);
            if (values == null || values.length != 3) {
                return Messages.ERROR_CODE_10051;
            }
            String email = values[0];
            long id = Long.parseLong(values[1]);
            String deviceHash = values[2];

            return iCoreUserDetailsDAO.isValidToken(email, id, deviceHash, token64) == 1 ? Messages.SUCCESS_CODE : Messages.ERROR_CODE_10050;
        } catch (CoreDAOException e) {
            e.printStackTrace();
            return e.getErrorCode();
        } catch (Exception ex) {
            return Messages.ERROR_CODE_10051;
        }
    }

    @Override
    @Transactional
    public ServiceResponse<Reserve> payValidation(long eventId, String seatId, String cardId, String token) {
        long validator = isValidToken(token);
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        try {
            long userId = Long.parseLong(decodedString(token)[1]);
            long eventValidate = iCoreEventDetailsDAO.validateEvent(eventId, seatId);
            if (eventValidate != Messages.SUCCESS_CODE) {
                return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(eventValidate), eventValidate);
            }
            long cardValidate = iCoreUserDetailsDAO.validateBankCard(userId, cardId, eventId, seatId);
            if (cardValidate == Messages.SUCCESS_CODE) {
                iCoreEventDetailsDAO.reserveSeat(eventId, seatId);
            } else {
                return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(cardValidate), cardValidate);
            }
            return new ServiceResponse<>(true);
        } catch (CoreDAOException e) {
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(e.getErrorCode()), e.getErrorCode());
        }
    }

    public String[] decodedString(String token64) {
        byte[] decodedBytes = Base64.getDecoder().decode(token64);
        String decodedString = new String(decodedBytes);
        return decodedString.split(FieldConstants.TOKEN_SEPARATOR);
    }

}
