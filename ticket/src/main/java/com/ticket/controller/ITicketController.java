package com.ticket.controller;

import com.core.common.ServiceResponse;
import com.core.eventdetails.model.Reserve;
import org.springframework.web.bind.annotation.*;
import com.core.eventdetails.model.Event;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public interface ITicketController {

    @GetMapping("/test")
    @ResponseBody
    ServiceResponse<List<Event>> getEvents(@RequestHeader Map<String, String> headers, HttpServletResponse response);

    @GetMapping("/getEvent/{id}")
    @ResponseBody
    ServiceResponse<Event> getEvent(@RequestHeader Map<String, String> headers, @PathVariable long id);

    @PostMapping("/pay/eventId/{eventId}/seatId/{seatId}/cardId/{cardId}")
    @ResponseBody
    ServiceResponse<Reserve> reserve(@RequestHeader Map<String, String> headers, @PathVariable long eventId, @PathVariable String seatId, @PathVariable String cardId);


}
