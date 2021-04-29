package com.gyenese.controller;

import com.gyenese.common.ApiResponse;
import com.gyenese.mock.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApiControllerImpl implements IApiController {



    @Override
    public ApiResponse<List<Event>> getEvents(Map<String, String> headers) {
        return null;
    }

    @Override
    public ApiResponse<Event> getEvent(Map<String, String> headers, long id) {
        return null;
    }
}
