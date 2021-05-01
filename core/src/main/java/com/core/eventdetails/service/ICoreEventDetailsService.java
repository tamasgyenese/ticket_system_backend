package com.core.eventdetails.service;

import com.core.eventdetails.model.Event;

import java.util.List;

public interface ICoreEventDetailsService {

    List<Event> getEvents();

    Event getEventDetails(long eventId);
}
