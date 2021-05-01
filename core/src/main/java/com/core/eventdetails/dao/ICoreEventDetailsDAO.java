package com.core.eventdetails.dao;

import com.core.eventdetails.model.Event;

import java.util.List;

public interface ICoreEventDetailsDAO {

    List<Event> getEvents();

    Event getEventDetails(long eventId);
}