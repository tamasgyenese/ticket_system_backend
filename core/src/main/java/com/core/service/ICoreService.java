package com.core.service;

import com.core.eventdetails.model.Event;

import java.util.List;

public interface ICoreService {

    long isValidToken(String token64);

    List<Event> getEvents();

    Event getEventDetails(long eventId);
}
