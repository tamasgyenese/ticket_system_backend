package com.api.controller;

import com.core.common.ServiceResponse;
import com.core.eventdetails.model.Reserve;
import org.springframework.web.bind.annotation.*;
import com.core.eventdetails.model.Event;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public interface ITicketController {

    @GetMapping("/getEvents")
    @ResponseBody
    ServiceResponse<List<Event>> getEvents(@RequestHeader Map<String, String> headers);

    @GetMapping("/getEvent/{id}")
    @ResponseBody
    ServiceResponse<Event> getEvent(@RequestHeader Map<String, String> headers, @PathVariable long id);

    @PostMapping("/pay/eventId/{eventId}/seatId/{seatId}/cardId/{cardId}")
    @ResponseBody
    ServiceResponse<Reserve> reserve(@RequestHeader Map<String, String> headers, @PathVariable long eventId, @PathVariable String seatId, @PathVariable String cardId);


}
