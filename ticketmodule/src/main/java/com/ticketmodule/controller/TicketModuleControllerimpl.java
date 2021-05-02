package com.ticketmodule.controller;

import com.core.common.ServiceResponse;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reserve;
import com.core.service.ICoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketModuleControllerimpl {

    Logger logger = LoggerFactory.getLogger(TicketModuleControllerimpl.class);

    private static final String HEADERS_AUTH = "authorization";

    private final ICoreService iCoreService;

    @Autowired
    public TicketModuleControllerimpl(ICoreService iCoreService) {
        this.iCoreService = iCoreService;
    }

    /**
     * Get List of Event after token validation
     * @param headers HTTP header Authentication credentials to authenticate a user
     * @return List of Event
     */
    @GetMapping("/getEvents")
    @ResponseBody
    public ServiceResponse<List<Event>> getEvents(@RequestHeader Map<String, String> headers) {
        logger.trace("Get all events from core module with header: {}", headers);
        return iCoreService.getEvents(headers.get(HEADERS_AUTH));
    }

    /**
     * Get details of event
     * @param headers HTTP header Authentication credentials to authenticate a user
     * @param id eventId
     * @return Event
     */
    @GetMapping("/getEvent/{id}")
    @ResponseBody
    public ServiceResponse<Event> getEvent(@RequestHeader Map<String, String> headers, long id) {
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
    @PostMapping("/pay/eventId/{eventId}/seatId/{seatId}/cardId/{cardId}")
    @ResponseBody
    public ServiceResponse<Reserve> reserve(@RequestHeader Map<String, String> headers, long eventId, String seatId, String cardId) {
        logger.trace("Trying to reserve a seat: {} for event: {} with cardid: {} and header: {}",seatId, eventId, cardId, headers);
        return iCoreService.payValidation(eventId, seatId, cardId,headers.get(HEADERS_AUTH));
    }
}
