package com.api.controller;

import com.core.common.ServiceResponse;
import com.core.constans.Messages;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reserve;
import com.core.eventdetails.service.ICoreEventDetailsService;
import com.core.userdetails.service.ICoreUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApiControllerImpl implements IApiController {

    private static final String HEADERS_AUTH = "authorization";

    private final ICoreUserDetailsService iCoreUserDetailsService;
    private final ICoreEventDetailsService iCoreEventDetailsService;

    @Autowired
    public ApiControllerImpl(ICoreUserDetailsService iCoreUserDetailsService, ICoreEventDetailsService iCoreEventDetailsService) {
        this.iCoreUserDetailsService = iCoreUserDetailsService;
        this.iCoreEventDetailsService = iCoreEventDetailsService;
    }

    @Override
    public ServiceResponse<List<Event>> getEvents(Map<String, String> headers) {
        long validator = iCoreUserDetailsService.isValidToken(headers.get(HEADERS_AUTH));
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null,false, Messages.messagesMap.get(validator), validator);
        }
        return new ServiceResponse<>(iCoreEventDetailsService.getEvents(),true);
    }

    @Override
    public ServiceResponse<Event> getEvent(Map<String, String> headers, long id) {
        long validator = iCoreUserDetailsService.isValidToken(headers.get(HEADERS_AUTH));
        if (validator != Messages.SUCCESS_CODE) {
            return new ServiceResponse<>(null,false, Messages.messagesMap.get(validator), validator);
        }
        return new ServiceResponse<>(iCoreEventDetailsService.getEventDetails(id),true);
    }

    @Override
    public ServiceResponse<Reserve> pay(Map<String, String> headers, int eventId, String seatId, int cardId) {
        return null;
    }
}
