package com.api.controller;

import com.core.common.ServiceResponse;
import com.core.constans.Messages;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reserve;
import com.core.service.ICoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TicketControllerimpl implements ITicketController {

    private static final String HEADERS_AUTH = "authorization";

    private final ICoreService iCoreService;

    @Autowired
    public TicketControllerimpl(ICoreService iCoreService) {
        this.iCoreService = iCoreService;
    }

    @Override
    public ServiceResponse<List<Event>> getEvents(Map<String, String> headers) {
        long validator = iCoreService.isValidToken(headers.get(HEADERS_AUTH));
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null,false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        return new ServiceResponse<>(iCoreService.getEvents(),true);
    }

    @Override
    public ServiceResponse<Event> getEvent(Map<String, String> headers, long id) {
        long validator = iCoreService.isValidToken(headers.get(HEADERS_AUTH));
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null,false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        return new ServiceResponse<>(iCoreService.getEventDetails(id),true);
    }

    @Override
    public ServiceResponse<Reserve> reserve(Map<String, String> headers, long eventId, String seatId, String cardId) {
        String token = headers.get(HEADERS_AUTH);
        long validator = iCoreService.isValidToken(token);
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null,false, Messages.MESSAGE_MAP.get(validator), validator);
        }
        validator = iCoreService.payValidation(eventId,seatId,cardId,token);
        if (validator == Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(true);
        } else {
            return new ServiceResponse<>(null, false, Messages.MESSAGE_MAP.get(validator), validator);
        }

    }
}
