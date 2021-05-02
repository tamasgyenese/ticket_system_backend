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
        return iCoreService.getEvents(headers.get(HEADERS_AUTH));
    }

    @Override
    public ServiceResponse<Event> getEvent(Map<String, String> headers, long id) {
        return iCoreService.getEventDetails(id,headers.get(HEADERS_AUTH));
    }

    @Override
    public ServiceResponse<Reserve> reserve(Map<String, String> headers, long eventId, String seatId, String cardId) {
        return iCoreService.payValidation(eventId, seatId, cardId,headers.get(HEADERS_AUTH));
    }
}
