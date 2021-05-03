package com.api.controller;

import com.core.common.ServiceResponse;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reservation;
import com.core.service.ICoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApiControllerImpl implements IApiController{

    Logger logger = LoggerFactory.getLogger(ApiControllerImpl.class);

    private static final String HEADERS_AUTH = "authorization";

    private final ICoreService iCoreService;

    @Autowired
    public ApiControllerImpl(ICoreService iCoreService) {
        this.iCoreService = iCoreService;
    }

    /**
     * Get List of Event after token validation
     * @param headers HTTP header Authentication credentials to authenticate a user
     * @return List of Event
     */
    @Override
    public ServiceResponse<List<Event>> getEvents(Map<String, String> headers) {
        logger.trace("Get all events from core module with header: {}", headers);
        return iCoreService.getEvents(headers.get(HEADERS_AUTH));
    }

    /**
     * Get details of event
     * @param headers HTTP header Authentication credentials to authenticate a user
     * @param id eventId
     * @return Event
     */
    @Override
    public ServiceResponse<Event> getEvent(Map<String, String> headers, long id) {
        logger.trace("Get event details for event: {} with header: {}", id, headers);
        return iCoreService.getEventDetails(id,headers.get(HEADERS_AUTH));
    }

    /**
     * Reserve a seat for an event with a card, if it's not possible get a reason
     * @param headers HTTP header Authentication credentials to authenticate a user
     * @param eventId
     * @param seatId
     * @param cardId
     * @return
     */
    @Override
    public ServiceResponse<Reservation> pay(Map<String, String> headers, long eventId, String seatId, String cardId) {
        logger.trace("Trying to reserve a seat: {} for event: {} with cardid: {} and header: {}",seatId, eventId, cardId, headers);
        return iCoreService.payValidation(eventId, seatId, cardId,headers.get(HEADERS_AUTH));
    }
}
