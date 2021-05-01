package com.api.controller;

import com.core.common.ServiceResponse;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reserve;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public interface IApiController {

    @GetMapping("/getEvents")
    @ResponseBody
    ServiceResponse<List<Event>> getEvents(@RequestHeader Map<String, String> headers);

    @GetMapping("/getEvent/{id}")
    @ResponseBody
    ServiceResponse<Event> getEvent(@RequestHeader Map<String, String> headers, @PathVariable long id);

    @PostMapping("/pay/eventId/{eventId}/seatId/{seatId}/cardId/{cardId}")
    @ResponseBody
    ServiceResponse<Reserve> pay(@RequestHeader Map<String, String> headers,@PathVariable int eventId, @PathVariable String seatId, @PathVariable int cardId);

}
