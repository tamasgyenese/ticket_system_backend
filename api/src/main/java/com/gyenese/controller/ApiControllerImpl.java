package com.gyenese.controller;

import com.gyenese.common.ServiceResponse;
import com.gyenese.mock.Event;
import com.gyenese.service.ICoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApiControllerImpl implements IApiController {

    private final ICoreService iCoreService;

    @Autowired
    public ApiControllerImpl(ICoreService iCoreService) {
        this.iCoreService = iCoreService;
    }


    @Override
    public ServiceResponse<List<Event>> getEvents(Map<String, String> headers) {
        return null;
    }

    @Override
    public ServiceResponse<Event> getEvent(Map<String, String> headers, long id) {
        return null;
    }
}
