package com.api.controller;

import com.core.common.ServiceResponse;
import com.core.constans.Messages;
import com.core.mock.Event;
import com.core.service.ICoreService;
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
        long validator = iCoreService.isValidToken(headers.get("authorization"));
        if (validator == 0L) {
            return new ServiceResponse<>(null,false, Messages.ERROR_MSG_10051, Messages.ERROR_CODE_10051);
        }

        return null;
    }

    @Override
    public ServiceResponse<Event> getEvent(Map<String, String> headers, long id) {
        return null;
    }
}
