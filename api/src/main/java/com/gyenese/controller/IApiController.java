package com.gyenese.controller;

import com.gyenese.common.ApiResponse;
import com.gyenese.mock.Event;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public interface IApiController {

    @GetMapping("/getEvents")
    @ResponseBody
    ApiResponse<List<Event>> getEvents(@RequestHeader Map<String, String> headers);

    @GetMapping("/getEvent/{id}")
    @ResponseBody
    ApiResponse<Event> getEvent(@RequestHeader Map<String, String> headers, @PathVariable long id);




}
